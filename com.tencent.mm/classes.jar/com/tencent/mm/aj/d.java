package com.tencent.mm.aj;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.f;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ccz;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class d
  implements com.tencent.mm.ak.i
{
  boolean iKb;
  Set<String> iKc;
  f<String, d> iKd;
  Stack<i> iKe;
  private QueueWorkerThread iKf;
  private QueueWorkerThread iKg;
  volatile String iKh;
  f<String, String> iKi;
  MTimerHandler iKj;
  
  public d()
  {
    AppMethodBeat.i(150226);
    this.iKb = false;
    this.iKc = Collections.synchronizedSet(new HashSet());
    this.iKd = new com.tencent.mm.memory.a.c(400);
    this.iKe = new Stack();
    this.iKf = null;
    this.iKg = null;
    this.iKi = new com.tencent.mm.memory.a.c(200);
    this.iKj = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      private long iKm = 0L;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150217);
        long l = System.currentTimeMillis();
        if ((d.this.iKb) && (l - this.iKm > 60000L))
        {
          Log.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", new Object[] { Long.valueOf(l - this.iKm) });
          d.this.iKb = false;
        }
        if (d.this.iKb)
        {
          d.this.iKj.startTimer(1000L);
          AppMethodBeat.o(150217);
          return false;
        }
        this.iKm = l;
        d.this.iKb = true;
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while ((i < 5) && (d.this.iKe.size() > 0))
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(138L, 42L, 1L, true);
          localLinkedList.add(new dqi().bhy(Util.nullAsNil(((i)d.this.iKe.pop()).getUsername())));
          i += 1;
        }
        g.azz().a(new k(localLinkedList), 0);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(138L, 44L, 1L, true);
        AppMethodBeat.o(150217);
        return false;
      }
    }, false);
    g.azz().a(123, this);
    this.iKb = false;
    this.iKh = z.aTY();
    AppMethodBeat.o(150226);
  }
  
  static i Mi(String paramString)
  {
    AppMethodBeat.i(150230);
    Object localObject1 = p.aYB().Mx(paramString);
    if ((localObject1 != null) && (((i)localObject1).getUsername().equals(paramString)))
    {
      Log.i("MicroMsg.AvatarService", "[isFlagNeed] getSmallUrl:%s username:%s", new Object[] { ((i)localObject1).aYu(), paramString });
      AppMethodBeat.o(150230);
      return localObject1;
    }
    localObject1 = ((l)g.af(l.class)).aSN().Kn(paramString);
    if (((ax)localObject1).fuz == 4)
    {
      c.ap(paramString, ((ax)localObject1).fuz);
      Log.d("MicroMsg.AvatarService", "ct imgFlag :%s", new Object[] { Integer.valueOf(((ax)localObject1).fuz) });
      AppMethodBeat.o(150230);
      return null;
    }
    localObject1 = new i();
    ((i)localObject1).username = paramString;
    ((i)localObject1).fuz = 3;
    Object localObject2 = ((l)g.af(l.class)).aSN().bjP(paramString);
    if (Util.isNullOrNil((byte[])localObject2))
    {
      Log.i("MicroMsg.AvatarService", "[isFlagNeed] cmdBuf is null! username:%s", new Object[] { paramString });
      AppMethodBeat.o(150230);
      return localObject1;
    }
    try
    {
      localObject2 = c.a(paramString, (cpl)new cpl().parseFrom((byte[])localObject2));
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AvatarService", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
    Log.i("MicroMsg.AvatarService", "[isFlagNeed] finally! getSmallUrl:%s getBigUrl:%s username:%s", new Object[] { ((i)localObject1).aYu(), ((i)localObject1).aYt(), paramString });
    AppMethodBeat.o(150230);
    return localObject1;
  }
  
  static e aYn()
  {
    AppMethodBeat.i(150234);
    if (g.aAf().azp())
    {
      e locale = p.aYn();
      AppMethodBeat.o(150234);
      return locale;
    }
    AppMethodBeat.o(150234);
    return null;
  }
  
  public final Bitmap K(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(223531);
    paramString = b(paramString, paramBoolean, 0, null);
    AppMethodBeat.o(223531);
    return paramString;
  }
  
  public final void Mg(String paramString)
  {
    AppMethodBeat.i(150228);
    a(new c(paramString));
    AppMethodBeat.o(150228);
  }
  
  public final void Mh(final String paramString)
  {
    AppMethodBeat.i(150229);
    com.tencent.f.h.RTc.aX(new com.tencent.f.i.j()
    {
      public final boolean axI()
      {
        return false;
      }
      
      public final String getKey()
      {
        return "AvatarService#checkAvatarExpire";
      }
      
      public final void run()
      {
        AppMethodBeat.i(150214);
        if (Util.isNullOrNil(paramString))
        {
          AppMethodBeat.o(150214);
          return;
        }
        if (paramString.equals(d.this.iKh))
        {
          Log.i("MicroMsg.AvatarService", "thisUser is empty!!");
          AppMethodBeat.o(150214);
          return;
        }
        Object localObject = d.aYo();
        if (localObject == null)
        {
          Log.i("MicroMsg.AvatarService", "istg is null!!");
          AppMethodBeat.o(150214);
          return;
        }
        localObject = ((j)localObject).Mx(paramString);
        if ((localObject == null) || (!((i)localObject).getUsername().equals(paramString)))
        {
          Log.i("MicroMsg.AvatarService", "imgFlag is null or username not equal");
          AppMethodBeat.o(150214);
          return;
        }
        if (Util.nowSecond() - ((i)localObject).iKZ * 60L > 86400L) {}
        for (int i = 1; i == 0; i = 0)
        {
          Log.i("MicroMsg.AvatarService", "imgFlag is expired!!");
          AppMethodBeat.o(150214);
          return;
        }
        if (Util.isNullOrNil(((i)localObject).aYu()))
        {
          Log.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", new Object[] { paramString });
          AppMethodBeat.o(150214);
          return;
        }
        d.this.Mg(paramString);
        AppMethodBeat.o(150214);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(150215);
        String str = super.toString() + "|checkAvatarExpire";
        AppMethodBeat.o(150215);
        return str;
      }
    });
    AppMethodBeat.o(150229);
  }
  
  public final String Mj(String paramString)
  {
    AppMethodBeat.i(150235);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150235);
      return "";
    }
    try
    {
      String str1 = String.format("%s%x_%s", new Object[] { "ammURL_", Integer.valueOf(paramString.hashCode()), paramString.substring(paramString.length() - 24, paramString.length() - 4) });
      this.iKi.put(str1, paramString);
      AppMethodBeat.o(150235);
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = String.format("%s%x_", new Object[] { "ammURL_", Integer.valueOf(paramString.hashCode()) });
      }
    }
  }
  
  final int a(final QueueWorkerThread.ThreadObject paramThreadObject)
  {
    AppMethodBeat.i(150232);
    com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
    {
      public final String getKey()
      {
        return "AvatarService#putAsyncTask";
      }
      
      public final void run()
      {
        AppMethodBeat.i(150216);
        paramThreadObject.doInBackground();
        paramThreadObject.onPostExecute();
        AppMethodBeat.o(150216);
      }
    });
    AppMethodBeat.o(150232);
    return 1;
  }
  
  public final Bitmap b(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(223532);
    e locale = aYn();
    Bitmap localBitmap2;
    if (locale != null) {
      if ((paramInt >= 0) && (paramInt > 5))
      {
        localBitmap2 = e.Mk(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
        if (localBitmap2 != null)
        {
          Log.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
          AppMethodBeat.o(223532);
          return localBitmap2;
        }
        Log.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
        localBitmap1 = localBitmap2;
        if (localBitmap2 != null) {}
      }
    }
    for (Bitmap localBitmap1 = e.Mk(paramString);; localBitmap1 = null)
    {
      if (localBitmap1 != null)
      {
        paramb = localBitmap1;
        if (paramInt >= 0)
        {
          paramb = localBitmap1;
          if (paramInt > 5)
          {
            Log.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
            paramb = BitmapUtil.getRoundedCornerBitmap(localBitmap1, false, paramInt);
            locale.d(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }), paramb);
          }
        }
        AppMethodBeat.o(223532);
        return paramb;
      }
      if (paramBoolean)
      {
        AppMethodBeat.o(223532);
        return null;
      }
      Log.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", new Object[] { paramString });
      if (this.iKc.contains(paramString))
      {
        AppMethodBeat.o(223532);
        return null;
      }
      this.iKc.add(paramString);
      a(new c(paramString, paramb));
      AppMethodBeat.o(223532);
      return null;
      localBitmap2 = null;
      break;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150231);
    while (this.iKe.size() > 0) {
      this.iKc.remove(this.iKe.pop());
    }
    AppMethodBeat.o(150231);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(150233);
    if (paramq == null)
    {
      AppMethodBeat.o(150233);
      return;
    }
    if (paramq.getType() != 123)
    {
      AppMethodBeat.o(150233);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(138L, 12L, 1L, true);
    }
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(138L, 45L, 1L, true);
    Object localObject;
    ccz localccz;
    try
    {
      paramq = (k)paramq;
      paramString = new HashSet();
      if (paramq.iLc != null)
      {
        localObject = paramq.iLc.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localccz = (ccz)((Iterator)localObject).next();
            if ((localccz == null) || (localccz.MiP == null))
            {
              Log.i("MicroMsg.AvatarService", "error p is null or username is null %s", new Object[] { localccz });
              continue;
              this.iKb = false;
            }
          }
        }
      }
    }
    catch (NullPointerException paramString)
    {
      Log.e("MicroMsg.AvatarService", "[onSceneEnd] NullPointerException:%s", new Object[] { paramString });
    }
    for (;;)
    {
      if (this.iKe.size() > 0) {
        this.iKj.startTimer(0L);
      }
      AppMethodBeat.o(150233);
      return;
      String str = localccz.MiP.MTo;
      if ((localccz.KHp == null) || (localccz.KHp.getBuffer() == null) || (localccz.KHp.getBuffer().zy == null))
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(138L, 11L, 1L, true);
        break;
      }
      paramString.add(str);
      i locali = new i();
      locali.username = str;
      locali.fuz = 3;
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(138L, 43L, 1L, true);
      a(new e(locali, localccz.KHp.getBuffer().zy));
      break;
      if (paramq.iLb != null)
      {
        paramq = paramq.iLb.iterator();
        while (paramq.hasNext())
        {
          localObject = (dqi)paramq.next();
          if (localObject != null)
          {
            localObject = ((dqi)localObject).MTo;
            if (!paramString.contains(localObject)) {
              this.iKc.remove(localObject);
            }
          }
        }
      }
    }
  }
  
  final class a
    implements QueueWorkerThread.ThreadObject
  {
    boolean bGA;
    i iKn;
    byte[] iKo;
    byte[] iKp;
    
    public a(i parami, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      this.iKn = parami;
      this.iKo = paramArrayOfByte;
      this.bGA = paramBoolean;
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(150218);
      byte[] arrayOfByte;
      if (this.bGA)
      {
        Log.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt");
        com.tencent.mm.plugin.report.service.h.CyF.dN(138, 51);
        arrayOfByte = UtilsJni.DecryptAvatar(this.iKo);
        if (Util.isNullOrNil(arrayOfByte))
        {
          com.tencent.mm.plugin.report.service.h.CyF.dN(138, 52);
          Log.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt output empty");
          AppMethodBeat.o(150218);
          return false;
        }
      }
      else
      {
        arrayOfByte = this.iKo;
      }
      for (;;)
      {
        if (ImgUtil.isWXGF(arrayOfByte))
        {
          Log.i("MicroMsg.AvatarService", "DecryptAvatar: hevc to pic");
          com.tencent.mm.plugin.report.service.h.CyF.dN(138, 53);
          this.iKp = ((com.tencent.mm.plugin.emoji.b.c)g.af(com.tencent.mm.plugin.emoji.b.c.class)).bn(arrayOfByte);
          if (Util.isNullOrNil(this.iKp))
          {
            com.tencent.mm.plugin.report.service.h.CyF.dN(138, 54);
            Log.i("MicroMsg.AvatarService", "DecryptAvatar: output is empty");
            AppMethodBeat.o(150218);
            return false;
          }
        }
        else
        {
          this.iKp = arrayOfByte;
        }
        AppMethodBeat.o(150218);
        return true;
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150219);
      if (!Util.isNullOrNil(this.iKp))
      {
        Log.i("MicroMsg.AvatarService", "DecryptAvatar: post to save length is %s", new Object[] { Integer.valueOf(this.iKp.length) });
        d.this.a(new d.e(d.this, this.iKn, this.iKp));
        AppMethodBeat.o(150219);
        return true;
      }
      Log.i("MicroMsg.AvatarService", "DecryptAvatar: onPostExecute output is empty");
      AppMethodBeat.o(150219);
      return false;
    }
  }
  
  final class b
    implements QueueWorkerThread.ThreadObject
  {
    public boolean bGA = false;
    public i iKq = null;
    public byte[] iKr = null;
    
    public b(i parami)
    {
      this.iKq = parami;
    }
    
    /* Error */
    public final boolean doInBackground()
    {
      // Byte code:
      //   0: ldc 42
      //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 26	com/tencent/mm/aj/d$b:iKq	Lcom/tencent/mm/aj/i;
      //   9: ifnonnull +10 -> 19
      //   12: ldc 42
      //   14: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   17: iconst_0
      //   18: ireturn
      //   19: invokestatic 57	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   22: invokestatic 63	com/tencent/mm/sdk/platformtools/NetStatusUtil:isNetworkConnected	(Landroid/content/Context;)Z
      //   25: ifne +13 -> 38
      //   28: ldc 65
      //   30: ldc 67
      //   32: invokestatic 73	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   35: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:appenderFlush	()V
      //   38: aload_0
      //   39: getfield 26	com/tencent/mm/aj/d$b:iKq	Lcom/tencent/mm/aj/i;
      //   42: invokevirtual 82	com/tencent/mm/aj/i:aYu	()Ljava/lang/String;
      //   45: astore 27
      //   47: ldc 84
      //   49: invokestatic 90	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   52: checkcast 84	com/tencent/mm/plugin/emoji/b/c
      //   55: invokeinterface 93 1 0
      //   60: istore_3
      //   61: ldc 95
      //   63: invokestatic 90	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   66: checkcast 95	com/tencent/mm/plugin/expt/b/b
      //   69: getstatic 101	com/tencent/mm/plugin/expt/b/b$a:rYv	Lcom/tencent/mm/plugin/expt/b/b$a;
      //   72: iconst_0
      //   73: invokeinterface 105 3 0
      //   78: istore 4
      //   80: iload_3
      //   81: ifeq +3772 -> 3853
      //   84: iload 4
      //   86: ifeq +3767 -> 3853
      //   89: ldc 65
      //   91: ldc 107
      //   93: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   96: aload 27
      //   98: ldc 111
      //   100: invokevirtual 117	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   103: ifeq +854 -> 957
      //   106: new 119	java/lang/StringBuilder
      //   109: dup
      //   110: invokespecial 120	java/lang/StringBuilder:<init>	()V
      //   113: aload 27
      //   115: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   118: ldc 126
      //   120: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   123: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   126: astore 15
      //   128: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   131: sipush 138
      //   134: bipush 50
      //   136: invokevirtual 139	com/tencent/mm/plugin/report/service/h:dN	(II)V
      //   139: aload 15
      //   141: astore 27
      //   143: invokestatic 143	com/tencent/mm/kernel/g:aAf	()Lcom/tencent/mm/kernel/a;
      //   146: invokevirtual 148	com/tencent/mm/kernel/a:azp	()Z
      //   149: ifeq +3696 -> 3845
      //   152: new 119	java/lang/StringBuilder
      //   155: dup
      //   156: ldc 150
      //   158: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   161: ldc 154
      //   163: invokestatic 160	com/tencent/mm/sdk/platformtools/WeChatHosts:domainString	(I)Ljava/lang/String;
      //   166: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   169: ldc 162
      //   171: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   174: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   177: astore 15
      //   179: getstatic 168	com/tencent/mm/protocal/d:KyO	I
      //   182: istore_1
      //   183: invokestatic 143	com/tencent/mm/kernel/g:aAf	()Lcom/tencent/mm/kernel/a;
      //   186: pop
      //   187: aload 15
      //   189: iconst_4
      //   190: anewarray 4	java/lang/Object
      //   193: dup
      //   194: iconst_0
      //   195: iload_1
      //   196: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   199: aastore
      //   200: dup
      //   201: iconst_1
      //   202: invokestatic 178	com/tencent/mm/kernel/a:getUin	()I
      //   205: invokestatic 183	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
      //   208: aastore
      //   209: dup
      //   210: iconst_2
      //   211: invokestatic 57	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   214: invokestatic 187	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetTypeForStat	(Landroid/content/Context;)I
      //   217: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   220: aastore
      //   221: dup
      //   222: iconst_3
      //   223: invokestatic 57	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   226: invokestatic 190	com/tencent/mm/sdk/platformtools/NetStatusUtil:getStrength	(Landroid/content/Context;)I
      //   229: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   232: aastore
      //   233: invokestatic 194	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   236: astore 17
      //   238: ldc 65
      //   240: ldc 196
      //   242: iconst_2
      //   243: anewarray 4	java/lang/Object
      //   246: dup
      //   247: iconst_0
      //   248: aload_0
      //   249: getfield 26	com/tencent/mm/aj/d$b:iKq	Lcom/tencent/mm/aj/i;
      //   252: invokevirtual 199	com/tencent/mm/aj/i:getUsername	()Ljava/lang/String;
      //   255: aastore
      //   256: dup
      //   257: iconst_1
      //   258: aload 17
      //   260: aastore
      //   261: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   264: aload_0
      //   265: aconst_null
      //   266: putfield 28	com/tencent/mm/aj/d$b:iKr	[B
      //   269: aconst_null
      //   270: astore 15
      //   272: aconst_null
      //   273: astore 19
      //   275: aconst_null
      //   276: astore 20
      //   278: aconst_null
      //   279: astore 29
      //   281: aconst_null
      //   282: astore 21
      //   284: aconst_null
      //   285: astore 28
      //   287: aconst_null
      //   288: astore 26
      //   290: aconst_null
      //   291: astore 18
      //   293: new 205	java/io/ByteArrayOutputStream
      //   296: dup
      //   297: invokespecial 206	java/io/ByteArrayOutputStream:<init>	()V
      //   300: astore 16
      //   302: aconst_null
      //   303: astore 23
      //   305: aconst_null
      //   306: astore 24
      //   308: aconst_null
      //   309: astore 25
      //   311: aconst_null
      //   312: astore 22
      //   314: lconst_0
      //   315: lstore 5
      //   317: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   320: ldc2_w 207
      //   323: ldc2_w 209
      //   326: lconst_1
      //   327: iconst_1
      //   328: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   331: lload 5
      //   333: lstore 7
      //   335: lload 5
      //   337: lstore 9
      //   339: lload 5
      //   341: lstore 11
      //   343: lload 5
      //   345: lstore 13
      //   347: invokestatic 220	java/lang/System:currentTimeMillis	()J
      //   350: lstore 5
      //   352: lload 5
      //   354: lstore 7
      //   356: lload 5
      //   358: lstore 9
      //   360: lload 5
      //   362: lstore 11
      //   364: lload 5
      //   366: lstore 13
      //   368: ldc 95
      //   370: invokestatic 90	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   373: checkcast 95	com/tencent/mm/plugin/expt/b/b
      //   376: getstatic 223	com/tencent/mm/plugin/expt/b/b$a:skc	Lcom/tencent/mm/plugin/expt/b/b$a;
      //   379: iconst_0
      //   380: invokeinterface 105 3 0
      //   385: istore_3
      //   386: iload_3
      //   387: ifeq +596 -> 983
      //   390: aload 29
      //   392: astore 20
      //   394: aload 28
      //   396: astore 21
      //   398: aload 27
      //   400: invokestatic 229	com/tencent/mm/network/d:RQ	(Ljava/lang/String;)Lcom/tencent/mm/network/z;
      //   403: astore 15
      //   405: aload 15
      //   407: checkcast 231	com/tencent/mm/network/z
      //   410: sipush 1224
      //   413: putfield 234	com/tencent/mm/network/z:jFq	I
      //   416: ldc 95
      //   418: invokestatic 90	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   421: checkcast 95	com/tencent/mm/plugin/expt/b/b
      //   424: getstatic 237	com/tencent/mm/plugin/expt/b/b$a:smr	Lcom/tencent/mm/plugin/expt/b/b$a;
      //   427: iconst_0
      //   428: invokeinterface 105 3 0
      //   433: istore 4
      //   435: aload 15
      //   437: checkcast 231	com/tencent/mm/network/z
      //   440: iload 4
      //   442: putfield 240	com/tencent/mm/network/z:jFr	Z
      //   445: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   448: ldc2_w 241
      //   451: ldc2_w 243
      //   454: lconst_1
      //   455: iconst_0
      //   456: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   459: aload 15
      //   461: astore 18
      //   463: aload 15
      //   465: astore 19
      //   467: aload 15
      //   469: astore 20
      //   471: aload 15
      //   473: astore 21
      //   475: aload 15
      //   477: ldc 246
      //   479: invokeinterface 251 2 0
      //   484: aload 15
      //   486: astore 18
      //   488: aload 15
      //   490: astore 19
      //   492: aload 15
      //   494: astore 20
      //   496: aload 15
      //   498: astore 21
      //   500: aload 15
      //   502: ldc 253
      //   504: aload 17
      //   506: invokeinterface 256 3 0
      //   511: aload 15
      //   513: astore 18
      //   515: aload 15
      //   517: astore 19
      //   519: aload 15
      //   521: astore 20
      //   523: aload 15
      //   525: astore 21
      //   527: aload 15
      //   529: sipush 5000
      //   532: invokeinterface 259 2 0
      //   537: aload 15
      //   539: astore 18
      //   541: aload 15
      //   543: astore 19
      //   545: aload 15
      //   547: astore 20
      //   549: aload 15
      //   551: astore 21
      //   553: aload 15
      //   555: sipush 5000
      //   558: invokeinterface 262 2 0
      //   563: aload 15
      //   565: astore 18
      //   567: aload 15
      //   569: astore 19
      //   571: aload 15
      //   573: astore 20
      //   575: aload 15
      //   577: astore 21
      //   579: aload 15
      //   581: invokeinterface 265 1 0
      //   586: istore_1
      //   587: iload_1
      //   588: sipush 200
      //   591: if_icmpeq +1936 -> 2527
      //   594: aload 15
      //   596: astore 18
      //   598: aload 15
      //   600: astore 19
      //   602: aload 15
      //   604: astore 20
      //   606: aload 15
      //   608: astore 21
      //   610: aload 15
      //   612: invokeinterface 269 1 0
      //   617: astore 17
      //   619: aload 17
      //   621: ifnull +395 -> 1016
      //   624: aload 15
      //   626: astore 18
      //   628: aload 15
      //   630: astore 19
      //   632: aload 15
      //   634: astore 20
      //   636: aload 15
      //   638: astore 21
      //   640: aload 17
      //   642: ldc_w 271
      //   645: invokeinterface 277 2 0
      //   650: checkcast 279	java/util/List
      //   653: astore 17
      //   655: aload 17
      //   657: ifnull +365 -> 1022
      //   660: aload 15
      //   662: astore 18
      //   664: aload 15
      //   666: astore 19
      //   668: aload 15
      //   670: astore 20
      //   672: aload 15
      //   674: astore 21
      //   676: aload 17
      //   678: invokeinterface 282 1 0
      //   683: ifle +339 -> 1022
      //   686: aload 15
      //   688: astore 18
      //   690: aload 15
      //   692: astore 19
      //   694: aload 15
      //   696: astore 20
      //   698: aload 15
      //   700: astore 21
      //   702: aload 17
      //   704: iconst_0
      //   705: invokeinterface 285 2 0
      //   710: checkcast 113	java/lang/String
      //   713: astore 17
      //   715: aload 15
      //   717: astore 18
      //   719: aload 15
      //   721: astore 19
      //   723: aload 15
      //   725: astore 20
      //   727: aload 15
      //   729: astore 21
      //   731: ldc 65
      //   733: ldc_w 287
      //   736: iconst_3
      //   737: anewarray 4	java/lang/Object
      //   740: dup
      //   741: iconst_0
      //   742: aload 27
      //   744: aastore
      //   745: dup
      //   746: iconst_1
      //   747: iload_1
      //   748: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   751: aastore
      //   752: dup
      //   753: iconst_2
      //   754: aload 17
      //   756: aastore
      //   757: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   760: iload_1
      //   761: lookupswitch	default:+3095->3856, 404:+269->1030, 502:+709->1470, 503:+1062->1823, 504:+1415->2176
      //   805: dconst_1
      //   806: astore 18
      //   808: aload 15
      //   810: astore 19
      //   812: aload 15
      //   814: astore 20
      //   816: aload 15
      //   818: astore 21
      //   820: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   823: ldc2_w 207
      //   826: ldc2_w 291
      //   829: lconst_1
      //   830: iconst_1
      //   831: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   834: aload 15
      //   836: astore 18
      //   838: aload 15
      //   840: astore 19
      //   842: aload 15
      //   844: astore 20
      //   846: aload 15
      //   848: astore 21
      //   850: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   853: sipush 14058
      //   856: bipush 10
      //   858: anewarray 4	java/lang/Object
      //   861: dup
      //   862: iconst_0
      //   863: ldc_w 293
      //   866: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   869: aastore
      //   870: dup
      //   871: iconst_1
      //   872: iload_1
      //   873: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   876: aastore
      //   877: dup
      //   878: iconst_2
      //   879: ldc_w 295
      //   882: aastore
      //   883: dup
      //   884: iconst_3
      //   885: iconst_0
      //   886: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   889: aastore
      //   890: dup
      //   891: iconst_4
      //   892: aload_0
      //   893: getfield 26	com/tencent/mm/aj/d$b:iKq	Lcom/tencent/mm/aj/i;
      //   896: invokevirtual 199	com/tencent/mm/aj/i:getUsername	()Ljava/lang/String;
      //   899: aastore
      //   900: dup
      //   901: iconst_5
      //   902: aload 15
      //   904: invokeinterface 298 1 0
      //   909: aastore
      //   910: dup
      //   911: bipush 6
      //   913: aload 15
      //   915: invokeinterface 301 1 0
      //   920: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   923: aastore
      //   924: dup
      //   925: bipush 7
      //   927: aload 15
      //   929: invokeinterface 304 1 0
      //   934: aastore
      //   935: dup
      //   936: bipush 8
      //   938: aload 27
      //   940: aastore
      //   941: dup
      //   942: bipush 9
      //   944: aload 17
      //   946: aastore
      //   947: invokevirtual 307	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
      //   950: ldc 42
      //   952: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   955: iconst_1
      //   956: ireturn
      //   957: new 119	java/lang/StringBuilder
      //   960: dup
      //   961: invokespecial 120	java/lang/StringBuilder:<init>	()V
      //   964: aload 27
      //   966: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   969: ldc_w 309
      //   972: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   975: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   978: astore 15
      //   980: goto -852 -> 128
      //   983: aload 29
      //   985: astore 20
      //   987: aload 28
      //   989: astore 21
      //   991: aload 27
      //   993: aconst_null
      //   994: invokestatic 312	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/x;
      //   997: astore 15
      //   999: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   1002: ldc2_w 241
      //   1005: ldc2_w 313
      //   1008: lconst_1
      //   1009: iconst_0
      //   1010: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1013: goto -554 -> 459
      //   1016: aconst_null
      //   1017: astore 17
      //   1019: goto -364 -> 655
      //   1022: ldc_w 295
      //   1025: astore 17
      //   1027: goto -312 -> 715
      //   1030: aload 15
      //   1032: astore 18
      //   1034: aload 15
      //   1036: astore 19
      //   1038: aload 15
      //   1040: astore 20
      //   1042: aload 15
      //   1044: astore 21
      //   1046: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   1049: ldc2_w 207
      //   1052: ldc2_w 315
      //   1055: lconst_1
      //   1056: iconst_1
      //   1057: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1060: aload 15
      //   1062: astore 18
      //   1064: aload 15
      //   1066: astore 19
      //   1068: aload 15
      //   1070: astore 20
      //   1072: aload 15
      //   1074: astore 21
      //   1076: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   1079: sipush 14058
      //   1082: bipush 10
      //   1084: anewarray 4	java/lang/Object
      //   1087: dup
      //   1088: iconst_0
      //   1089: ldc_w 293
      //   1092: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1095: aastore
      //   1096: dup
      //   1097: iconst_1
      //   1098: iload_1
      //   1099: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1102: aastore
      //   1103: dup
      //   1104: iconst_2
      //   1105: ldc_w 295
      //   1108: aastore
      //   1109: dup
      //   1110: iconst_3
      //   1111: iconst_0
      //   1112: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1115: aastore
      //   1116: dup
      //   1117: iconst_4
      //   1118: aload_0
      //   1119: getfield 26	com/tencent/mm/aj/d$b:iKq	Lcom/tencent/mm/aj/i;
      //   1122: invokevirtual 199	com/tencent/mm/aj/i:getUsername	()Ljava/lang/String;
      //   1125: aastore
      //   1126: dup
      //   1127: iconst_5
      //   1128: aload 15
      //   1130: invokeinterface 298 1 0
      //   1135: aastore
      //   1136: dup
      //   1137: bipush 6
      //   1139: aload 15
      //   1141: invokeinterface 301 1 0
      //   1146: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1149: aastore
      //   1150: dup
      //   1151: bipush 7
      //   1153: aload 15
      //   1155: invokeinterface 304 1 0
      //   1160: aastore
      //   1161: dup
      //   1162: bipush 8
      //   1164: aload 27
      //   1166: aastore
      //   1167: dup
      //   1168: bipush 9
      //   1170: aload 17
      //   1172: aastore
      //   1173: invokevirtual 307	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
      //   1176: goto -226 -> 950
      //   1179: astore 17
      //   1181: aload 18
      //   1183: astore 15
      //   1185: aload 22
      //   1187: astore 18
      //   1189: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   1192: ldc2_w 207
      //   1195: lconst_1
      //   1196: lconst_1
      //   1197: iconst_1
      //   1198: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1201: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   1204: astore 22
      //   1206: aload 17
      //   1208: invokevirtual 319	java/net/ProtocolException:getMessage	()Ljava/lang/String;
      //   1211: astore 23
      //   1213: aload_0
      //   1214: getfield 26	com/tencent/mm/aj/d$b:iKq	Lcom/tencent/mm/aj/i;
      //   1217: invokevirtual 199	com/tencent/mm/aj/i:getUsername	()Ljava/lang/String;
      //   1220: astore 24
      //   1222: aload 15
      //   1224: ifnonnull +2063 -> 3287
      //   1227: ldc_w 321
      //   1230: astore 19
      //   1232: aload 15
      //   1234: ifnonnull +2065 -> 3299
      //   1237: ldc_w 321
      //   1240: astore 20
      //   1242: aload 15
      //   1244: ifnonnull +2070 -> 3314
      //   1247: ldc_w 321
      //   1250: astore 21
      //   1252: aload 22
      //   1254: sipush 14058
      //   1257: bipush 10
      //   1259: anewarray 4	java/lang/Object
      //   1262: dup
      //   1263: iconst_0
      //   1264: ldc_w 293
      //   1267: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1270: aastore
      //   1271: dup
      //   1272: iconst_1
      //   1273: sipush 10001
      //   1276: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1279: aastore
      //   1280: dup
      //   1281: iconst_2
      //   1282: aload 23
      //   1284: aastore
      //   1285: dup
      //   1286: iconst_3
      //   1287: iconst_0
      //   1288: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1291: aastore
      //   1292: dup
      //   1293: iconst_4
      //   1294: aload 24
      //   1296: aastore
      //   1297: dup
      //   1298: iconst_5
      //   1299: aload 19
      //   1301: aastore
      //   1302: dup
      //   1303: bipush 6
      //   1305: aload 20
      //   1307: aastore
      //   1308: dup
      //   1309: bipush 7
      //   1311: aload 21
      //   1313: aastore
      //   1314: dup
      //   1315: bipush 8
      //   1317: aload 27
      //   1319: aastore
      //   1320: dup
      //   1321: bipush 9
      //   1323: ldc_w 295
      //   1326: aastore
      //   1327: invokevirtual 307	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
      //   1330: ldc 65
      //   1332: ldc_w 323
      //   1335: iconst_3
      //   1336: anewarray 4	java/lang/Object
      //   1339: dup
      //   1340: iconst_0
      //   1341: aload 27
      //   1343: aastore
      //   1344: dup
      //   1345: iconst_1
      //   1346: aload 17
      //   1348: invokevirtual 327	java/lang/Object:getClass	()Ljava/lang/Class;
      //   1351: invokevirtual 332	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   1354: aastore
      //   1355: dup
      //   1356: iconst_2
      //   1357: aload 17
      //   1359: invokevirtual 319	java/net/ProtocolException:getMessage	()Ljava/lang/String;
      //   1362: aastore
      //   1363: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1366: aload 16
      //   1368: astore 17
      //   1370: aload 18
      //   1372: astore 16
      //   1374: aload 15
      //   1376: ifnull +10 -> 1386
      //   1379: aload 15
      //   1381: invokeinterface 335 1 0
      //   1386: aload 16
      //   1388: ifnull +8 -> 1396
      //   1391: aload 16
      //   1393: invokevirtual 340	java/io/InputStream:close	()V
      //   1396: aload 17
      //   1398: ifnull +8 -> 1406
      //   1401: aload 17
      //   1403: invokevirtual 341	java/io/ByteArrayOutputStream:close	()V
      //   1406: invokestatic 220	java/lang/System:currentTimeMillis	()J
      //   1409: lload 5
      //   1411: lsub
      //   1412: lstore 5
      //   1414: iload_3
      //   1415: ifeq +2028 -> 3443
      //   1418: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   1421: ldc2_w 241
      //   1424: ldc2_w 342
      //   1427: lload 5
      //   1429: iconst_0
      //   1430: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1433: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   1436: ldc2_w 241
      //   1439: ldc2_w 344
      //   1442: lconst_1
      //   1443: iconst_0
      //   1444: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1447: ldc 65
      //   1449: ldc_w 347
      //   1452: lload 5
      //   1454: invokestatic 350	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   1457: invokevirtual 354	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   1460: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1463: ldc 42
      //   1465: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1468: iconst_1
      //   1469: ireturn
      //   1470: aload 15
      //   1472: astore 18
      //   1474: aload 15
      //   1476: astore 19
      //   1478: aload 15
      //   1480: astore 20
      //   1482: aload 15
      //   1484: astore 21
      //   1486: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   1489: ldc2_w 207
      //   1492: ldc2_w 355
      //   1495: lconst_1
      //   1496: iconst_1
      //   1497: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1500: aload 15
      //   1502: astore 18
      //   1504: aload 15
      //   1506: astore 19
      //   1508: aload 15
      //   1510: astore 20
      //   1512: aload 15
      //   1514: astore 21
      //   1516: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   1519: sipush 14058
      //   1522: bipush 10
      //   1524: anewarray 4	java/lang/Object
      //   1527: dup
      //   1528: iconst_0
      //   1529: ldc_w 293
      //   1532: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1535: aastore
      //   1536: dup
      //   1537: iconst_1
      //   1538: iload_1
      //   1539: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1542: aastore
      //   1543: dup
      //   1544: iconst_2
      //   1545: ldc_w 295
      //   1548: aastore
      //   1549: dup
      //   1550: iconst_3
      //   1551: iconst_0
      //   1552: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1555: aastore
      //   1556: dup
      //   1557: iconst_4
      //   1558: aload_0
      //   1559: getfield 26	com/tencent/mm/aj/d$b:iKq	Lcom/tencent/mm/aj/i;
      //   1562: invokevirtual 199	com/tencent/mm/aj/i:getUsername	()Ljava/lang/String;
      //   1565: aastore
      //   1566: dup
      //   1567: iconst_5
      //   1568: aload 15
      //   1570: invokeinterface 298 1 0
      //   1575: aastore
      //   1576: dup
      //   1577: bipush 6
      //   1579: aload 15
      //   1581: invokeinterface 301 1 0
      //   1586: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1589: aastore
      //   1590: dup
      //   1591: bipush 7
      //   1593: aload 15
      //   1595: invokeinterface 304 1 0
      //   1600: aastore
      //   1601: dup
      //   1602: bipush 8
      //   1604: aload 27
      //   1606: aastore
      //   1607: dup
      //   1608: bipush 9
      //   1610: aload 17
      //   1612: aastore
      //   1613: invokevirtual 307	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
      //   1616: goto -666 -> 950
      //   1619: astore 17
      //   1621: aload 19
      //   1623: astore 15
      //   1625: aload 16
      //   1627: astore 19
      //   1629: aload 23
      //   1631: astore 18
      //   1633: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   1636: ldc2_w 207
      //   1639: ldc2_w 357
      //   1642: lconst_1
      //   1643: iconst_1
      //   1644: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1647: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   1650: astore 22
      //   1652: aload 17
      //   1654: invokevirtual 359	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
      //   1657: astore 23
      //   1659: aload_0
      //   1660: getfield 26	com/tencent/mm/aj/d$b:iKq	Lcom/tencent/mm/aj/i;
      //   1663: invokevirtual 199	com/tencent/mm/aj/i:getUsername	()Ljava/lang/String;
      //   1666: astore 24
      //   1668: aload 15
      //   1670: ifnonnull +1656 -> 3326
      //   1673: ldc_w 321
      //   1676: astore 16
      //   1678: aload 15
      //   1680: ifnonnull +1658 -> 3338
      //   1683: ldc_w 321
      //   1686: astore 20
      //   1688: aload 15
      //   1690: ifnonnull +1663 -> 3353
      //   1693: ldc_w 321
      //   1696: astore 21
      //   1698: aload 22
      //   1700: sipush 14058
      //   1703: bipush 10
      //   1705: anewarray 4	java/lang/Object
      //   1708: dup
      //   1709: iconst_0
      //   1710: ldc_w 293
      //   1713: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1716: aastore
      //   1717: dup
      //   1718: iconst_1
      //   1719: sipush 10002
      //   1722: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1725: aastore
      //   1726: dup
      //   1727: iconst_2
      //   1728: aload 23
      //   1730: aastore
      //   1731: dup
      //   1732: iconst_3
      //   1733: iconst_0
      //   1734: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1737: aastore
      //   1738: dup
      //   1739: iconst_4
      //   1740: aload 24
      //   1742: aastore
      //   1743: dup
      //   1744: iconst_5
      //   1745: aload 16
      //   1747: aastore
      //   1748: dup
      //   1749: bipush 6
      //   1751: aload 20
      //   1753: aastore
      //   1754: dup
      //   1755: bipush 7
      //   1757: aload 21
      //   1759: aastore
      //   1760: dup
      //   1761: bipush 8
      //   1763: aload 27
      //   1765: aastore
      //   1766: dup
      //   1767: bipush 9
      //   1769: ldc_w 295
      //   1772: aastore
      //   1773: invokevirtual 307	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
      //   1776: ldc 65
      //   1778: ldc_w 323
      //   1781: iconst_3
      //   1782: anewarray 4	java/lang/Object
      //   1785: dup
      //   1786: iconst_0
      //   1787: aload 27
      //   1789: aastore
      //   1790: dup
      //   1791: iconst_1
      //   1792: aload 17
      //   1794: invokevirtual 327	java/lang/Object:getClass	()Ljava/lang/Class;
      //   1797: invokevirtual 332	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   1800: aastore
      //   1801: dup
      //   1802: iconst_2
      //   1803: aload 17
      //   1805: invokevirtual 359	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
      //   1808: aastore
      //   1809: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1812: aload 18
      //   1814: astore 16
      //   1816: aload 19
      //   1818: astore 17
      //   1820: goto -446 -> 1374
      //   1823: aload 15
      //   1825: astore 18
      //   1827: aload 15
      //   1829: astore 19
      //   1831: aload 15
      //   1833: astore 20
      //   1835: aload 15
      //   1837: astore 21
      //   1839: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   1842: ldc2_w 207
      //   1845: ldc2_w 360
      //   1848: lconst_1
      //   1849: iconst_1
      //   1850: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1853: aload 15
      //   1855: astore 18
      //   1857: aload 15
      //   1859: astore 19
      //   1861: aload 15
      //   1863: astore 20
      //   1865: aload 15
      //   1867: astore 21
      //   1869: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   1872: sipush 14058
      //   1875: bipush 10
      //   1877: anewarray 4	java/lang/Object
      //   1880: dup
      //   1881: iconst_0
      //   1882: ldc_w 293
      //   1885: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1888: aastore
      //   1889: dup
      //   1890: iconst_1
      //   1891: iload_1
      //   1892: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1895: aastore
      //   1896: dup
      //   1897: iconst_2
      //   1898: ldc_w 295
      //   1901: aastore
      //   1902: dup
      //   1903: iconst_3
      //   1904: iconst_0
      //   1905: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1908: aastore
      //   1909: dup
      //   1910: iconst_4
      //   1911: aload_0
      //   1912: getfield 26	com/tencent/mm/aj/d$b:iKq	Lcom/tencent/mm/aj/i;
      //   1915: invokevirtual 199	com/tencent/mm/aj/i:getUsername	()Ljava/lang/String;
      //   1918: aastore
      //   1919: dup
      //   1920: iconst_5
      //   1921: aload 15
      //   1923: invokeinterface 298 1 0
      //   1928: aastore
      //   1929: dup
      //   1930: bipush 6
      //   1932: aload 15
      //   1934: invokeinterface 301 1 0
      //   1939: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1942: aastore
      //   1943: dup
      //   1944: bipush 7
      //   1946: aload 15
      //   1948: invokeinterface 304 1 0
      //   1953: aastore
      //   1954: dup
      //   1955: bipush 8
      //   1957: aload 27
      //   1959: aastore
      //   1960: dup
      //   1961: bipush 9
      //   1963: aload 17
      //   1965: aastore
      //   1966: invokevirtual 307	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
      //   1969: goto -1019 -> 950
      //   1972: astore 17
      //   1974: aload 20
      //   1976: astore 15
      //   1978: aload 16
      //   1980: astore 19
      //   1982: aload 24
      //   1984: astore 18
      //   1986: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   1989: ldc2_w 207
      //   1992: ldc2_w 362
      //   1995: lconst_1
      //   1996: iconst_1
      //   1997: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   2000: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   2003: astore 22
      //   2005: aload 17
      //   2007: invokevirtual 364	java/io/IOException:getMessage	()Ljava/lang/String;
      //   2010: astore 23
      //   2012: aload_0
      //   2013: getfield 26	com/tencent/mm/aj/d$b:iKq	Lcom/tencent/mm/aj/i;
      //   2016: invokevirtual 199	com/tencent/mm/aj/i:getUsername	()Ljava/lang/String;
      //   2019: astore 24
      //   2021: aload 15
      //   2023: ifnonnull +1342 -> 3365
      //   2026: ldc_w 321
      //   2029: astore 16
      //   2031: aload 15
      //   2033: ifnonnull +1344 -> 3377
      //   2036: ldc_w 321
      //   2039: astore 20
      //   2041: aload 15
      //   2043: ifnonnull +1349 -> 3392
      //   2046: ldc_w 321
      //   2049: astore 21
      //   2051: aload 22
      //   2053: sipush 14058
      //   2056: bipush 10
      //   2058: anewarray 4	java/lang/Object
      //   2061: dup
      //   2062: iconst_0
      //   2063: ldc_w 293
      //   2066: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2069: aastore
      //   2070: dup
      //   2071: iconst_1
      //   2072: sipush 10003
      //   2075: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2078: aastore
      //   2079: dup
      //   2080: iconst_2
      //   2081: aload 23
      //   2083: aastore
      //   2084: dup
      //   2085: iconst_3
      //   2086: iconst_0
      //   2087: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2090: aastore
      //   2091: dup
      //   2092: iconst_4
      //   2093: aload 24
      //   2095: aastore
      //   2096: dup
      //   2097: iconst_5
      //   2098: aload 16
      //   2100: aastore
      //   2101: dup
      //   2102: bipush 6
      //   2104: aload 20
      //   2106: aastore
      //   2107: dup
      //   2108: bipush 7
      //   2110: aload 21
      //   2112: aastore
      //   2113: dup
      //   2114: bipush 8
      //   2116: aload 27
      //   2118: aastore
      //   2119: dup
      //   2120: bipush 9
      //   2122: ldc_w 295
      //   2125: aastore
      //   2126: invokevirtual 307	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
      //   2129: ldc 65
      //   2131: ldc_w 323
      //   2134: iconst_3
      //   2135: anewarray 4	java/lang/Object
      //   2138: dup
      //   2139: iconst_0
      //   2140: aload 27
      //   2142: aastore
      //   2143: dup
      //   2144: iconst_1
      //   2145: aload 17
      //   2147: invokevirtual 327	java/lang/Object:getClass	()Ljava/lang/Class;
      //   2150: invokevirtual 332	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   2153: aastore
      //   2154: dup
      //   2155: iconst_2
      //   2156: aload 17
      //   2158: invokevirtual 364	java/io/IOException:getMessage	()Ljava/lang/String;
      //   2161: aastore
      //   2162: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2165: aload 18
      //   2167: astore 16
      //   2169: aload 19
      //   2171: astore 17
      //   2173: goto -799 -> 1374
      //   2176: aload 15
      //   2178: astore 18
      //   2180: aload 15
      //   2182: astore 19
      //   2184: aload 15
      //   2186: astore 20
      //   2188: aload 15
      //   2190: astore 21
      //   2192: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   2195: ldc2_w 207
      //   2198: ldc2_w 365
      //   2201: lconst_1
      //   2202: iconst_1
      //   2203: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   2206: aload 15
      //   2208: astore 18
      //   2210: aload 15
      //   2212: astore 19
      //   2214: aload 15
      //   2216: astore 20
      //   2218: aload 15
      //   2220: astore 21
      //   2222: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   2225: sipush 14058
      //   2228: bipush 10
      //   2230: anewarray 4	java/lang/Object
      //   2233: dup
      //   2234: iconst_0
      //   2235: ldc_w 293
      //   2238: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2241: aastore
      //   2242: dup
      //   2243: iconst_1
      //   2244: iload_1
      //   2245: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2248: aastore
      //   2249: dup
      //   2250: iconst_2
      //   2251: ldc_w 295
      //   2254: aastore
      //   2255: dup
      //   2256: iconst_3
      //   2257: iconst_0
      //   2258: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2261: aastore
      //   2262: dup
      //   2263: iconst_4
      //   2264: aload_0
      //   2265: getfield 26	com/tencent/mm/aj/d$b:iKq	Lcom/tencent/mm/aj/i;
      //   2268: invokevirtual 199	com/tencent/mm/aj/i:getUsername	()Ljava/lang/String;
      //   2271: aastore
      //   2272: dup
      //   2273: iconst_5
      //   2274: aload 15
      //   2276: invokeinterface 298 1 0
      //   2281: aastore
      //   2282: dup
      //   2283: bipush 6
      //   2285: aload 15
      //   2287: invokeinterface 301 1 0
      //   2292: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2295: aastore
      //   2296: dup
      //   2297: bipush 7
      //   2299: aload 15
      //   2301: invokeinterface 304 1 0
      //   2306: aastore
      //   2307: dup
      //   2308: bipush 8
      //   2310: aload 27
      //   2312: aastore
      //   2313: dup
      //   2314: bipush 9
      //   2316: aload 17
      //   2318: aastore
      //   2319: invokevirtual 307	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
      //   2322: goto -1372 -> 950
      //   2325: astore 17
      //   2327: aload 21
      //   2329: astore 15
      //   2331: aload 16
      //   2333: astore 19
      //   2335: aload 25
      //   2337: astore 18
      //   2339: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   2342: ldc2_w 207
      //   2345: lconst_0
      //   2346: lconst_1
      //   2347: iconst_1
      //   2348: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   2351: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   2354: astore 22
      //   2356: aload 17
      //   2358: invokevirtual 367	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   2361: astore 23
      //   2363: aload_0
      //   2364: getfield 26	com/tencent/mm/aj/d$b:iKq	Lcom/tencent/mm/aj/i;
      //   2367: invokevirtual 199	com/tencent/mm/aj/i:getUsername	()Ljava/lang/String;
      //   2370: astore 24
      //   2372: aload 15
      //   2374: ifnonnull +1030 -> 3404
      //   2377: ldc_w 321
      //   2380: astore 16
      //   2382: aload 15
      //   2384: ifnonnull +1032 -> 3416
      //   2387: ldc_w 321
      //   2390: astore 20
      //   2392: aload 15
      //   2394: ifnonnull +1037 -> 3431
      //   2397: ldc_w 321
      //   2400: astore 21
      //   2402: aload 22
      //   2404: sipush 14058
      //   2407: bipush 10
      //   2409: anewarray 4	java/lang/Object
      //   2412: dup
      //   2413: iconst_0
      //   2414: ldc_w 293
      //   2417: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2420: aastore
      //   2421: dup
      //   2422: iconst_1
      //   2423: sipush 10003
      //   2426: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2429: aastore
      //   2430: dup
      //   2431: iconst_2
      //   2432: aload 23
      //   2434: aastore
      //   2435: dup
      //   2436: iconst_3
      //   2437: iconst_0
      //   2438: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2441: aastore
      //   2442: dup
      //   2443: iconst_4
      //   2444: aload 24
      //   2446: aastore
      //   2447: dup
      //   2448: iconst_5
      //   2449: aload 16
      //   2451: aastore
      //   2452: dup
      //   2453: bipush 6
      //   2455: aload 20
      //   2457: aastore
      //   2458: dup
      //   2459: bipush 7
      //   2461: aload 21
      //   2463: aastore
      //   2464: dup
      //   2465: bipush 8
      //   2467: aload 27
      //   2469: aastore
      //   2470: dup
      //   2471: bipush 9
      //   2473: ldc_w 295
      //   2476: aastore
      //   2477: invokevirtual 307	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
      //   2480: ldc 65
      //   2482: ldc_w 323
      //   2485: iconst_3
      //   2486: anewarray 4	java/lang/Object
      //   2489: dup
      //   2490: iconst_0
      //   2491: aload 27
      //   2493: aastore
      //   2494: dup
      //   2495: iconst_1
      //   2496: aload 17
      //   2498: invokevirtual 327	java/lang/Object:getClass	()Ljava/lang/Class;
      //   2501: invokevirtual 332	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   2504: aastore
      //   2505: dup
      //   2506: iconst_2
      //   2507: aload 17
      //   2509: invokevirtual 367	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   2512: aastore
      //   2513: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2516: aload 18
      //   2518: astore 16
      //   2520: aload 19
      //   2522: astore 17
      //   2524: goto -1150 -> 1374
      //   2527: aload 15
      //   2529: astore 18
      //   2531: aload 15
      //   2533: astore 19
      //   2535: aload 15
      //   2537: astore 20
      //   2539: aload 15
      //   2541: astore 21
      //   2543: aload 15
      //   2545: ldc_w 369
      //   2548: iconst_0
      //   2549: invokeinterface 373 3 0
      //   2554: iconst_1
      //   2555: if_icmpne +138 -> 2693
      //   2558: iconst_1
      //   2559: istore 4
      //   2561: aload 15
      //   2563: astore 18
      //   2565: aload 15
      //   2567: astore 19
      //   2569: aload 15
      //   2571: astore 20
      //   2573: aload 15
      //   2575: astore 21
      //   2577: aload_0
      //   2578: iload 4
      //   2580: putfield 30	com/tencent/mm/aj/d$b:bGA	Z
      //   2583: aload 15
      //   2585: astore 18
      //   2587: aload 15
      //   2589: astore 19
      //   2591: aload 15
      //   2593: astore 20
      //   2595: aload 15
      //   2597: astore 21
      //   2599: aload 15
      //   2601: invokeinterface 376 1 0
      //   2606: istore_1
      //   2607: aload 15
      //   2609: astore 18
      //   2611: aload 15
      //   2613: astore 19
      //   2615: aload 15
      //   2617: astore 20
      //   2619: aload 15
      //   2621: astore 21
      //   2623: aload 15
      //   2625: invokeinterface 380 1 0
      //   2630: astore 17
      //   2632: aload 17
      //   2634: ifnonnull +65 -> 2699
      //   2637: aload 16
      //   2639: astore 19
      //   2641: aload 15
      //   2643: astore 20
      //   2645: aload 16
      //   2647: astore 21
      //   2649: aload 15
      //   2651: astore 22
      //   2653: aload 16
      //   2655: astore 23
      //   2657: aload 15
      //   2659: astore 24
      //   2661: aload 16
      //   2663: astore 25
      //   2665: aload 15
      //   2667: astore 26
      //   2669: ldc 65
      //   2671: ldc_w 382
      //   2674: iconst_1
      //   2675: anewarray 4	java/lang/Object
      //   2678: dup
      //   2679: iconst_0
      //   2680: aload 27
      //   2682: aastore
      //   2683: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2686: ldc 42
      //   2688: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2691: iconst_1
      //   2692: ireturn
      //   2693: iconst_0
      //   2694: istore 4
      //   2696: goto -135 -> 2561
      //   2699: aload 16
      //   2701: astore 19
      //   2703: aload 15
      //   2705: astore 20
      //   2707: aload 16
      //   2709: astore 21
      //   2711: aload 15
      //   2713: astore 22
      //   2715: aload 16
      //   2717: astore 23
      //   2719: aload 15
      //   2721: astore 24
      //   2723: aload 16
      //   2725: astore 25
      //   2727: aload 15
      //   2729: astore 26
      //   2731: sipush 1024
      //   2734: newarray byte
      //   2736: astore 18
      //   2738: aload 16
      //   2740: astore 19
      //   2742: aload 15
      //   2744: astore 20
      //   2746: aload 16
      //   2748: astore 21
      //   2750: aload 15
      //   2752: astore 22
      //   2754: aload 16
      //   2756: astore 23
      //   2758: aload 15
      //   2760: astore 24
      //   2762: aload 16
      //   2764: astore 25
      //   2766: aload 15
      //   2768: astore 26
      //   2770: aload 17
      //   2772: aload 18
      //   2774: invokevirtual 386	java/io/InputStream:read	([B)I
      //   2777: istore_2
      //   2778: iload_2
      //   2779: iconst_m1
      //   2780: if_icmpeq +47 -> 2827
      //   2783: aload 16
      //   2785: astore 19
      //   2787: aload 15
      //   2789: astore 20
      //   2791: aload 16
      //   2793: astore 21
      //   2795: aload 15
      //   2797: astore 22
      //   2799: aload 16
      //   2801: astore 23
      //   2803: aload 15
      //   2805: astore 24
      //   2807: aload 16
      //   2809: astore 25
      //   2811: aload 15
      //   2813: astore 26
      //   2815: aload 16
      //   2817: aload 18
      //   2819: iconst_0
      //   2820: iload_2
      //   2821: invokevirtual 390	java/io/ByteArrayOutputStream:write	([BII)V
      //   2824: goto -86 -> 2738
      //   2827: aload 16
      //   2829: astore 19
      //   2831: aload 15
      //   2833: astore 20
      //   2835: aload 16
      //   2837: astore 21
      //   2839: aload 15
      //   2841: astore 22
      //   2843: aload 16
      //   2845: astore 23
      //   2847: aload 15
      //   2849: astore 24
      //   2851: aload 16
      //   2853: astore 25
      //   2855: aload 15
      //   2857: astore 26
      //   2859: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   2862: ldc2_w 207
      //   2865: ldc2_w 391
      //   2868: lconst_1
      //   2869: iconst_1
      //   2870: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   2873: aload 16
      //   2875: astore 19
      //   2877: aload 15
      //   2879: astore 20
      //   2881: aload 16
      //   2883: astore 21
      //   2885: aload 15
      //   2887: astore 22
      //   2889: aload 16
      //   2891: astore 23
      //   2893: aload 15
      //   2895: astore 24
      //   2897: aload 16
      //   2899: astore 25
      //   2901: aload 15
      //   2903: astore 26
      //   2905: invokestatic 397	com/tencent/mm/sdk/crash/CrashReportFactory:hasDebuger	()Z
      //   2908: ifeq +138 -> 3046
      //   2911: aload 16
      //   2913: astore 19
      //   2915: aload 15
      //   2917: astore 20
      //   2919: aload 16
      //   2921: astore 21
      //   2923: aload 15
      //   2925: astore 22
      //   2927: aload 16
      //   2929: astore 23
      //   2931: aload 15
      //   2933: astore 24
      //   2935: aload 16
      //   2937: astore 25
      //   2939: aload 15
      //   2941: astore 26
      //   2943: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   2946: sipush 14058
      //   2949: bipush 10
      //   2951: anewarray 4	java/lang/Object
      //   2954: dup
      //   2955: iconst_0
      //   2956: ldc_w 293
      //   2959: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2962: aastore
      //   2963: dup
      //   2964: iconst_1
      //   2965: sipush 20000
      //   2968: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2971: aastore
      //   2972: dup
      //   2973: iconst_2
      //   2974: ldc_w 295
      //   2977: aastore
      //   2978: dup
      //   2979: iconst_3
      //   2980: iload_1
      //   2981: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2984: aastore
      //   2985: dup
      //   2986: iconst_4
      //   2987: aload_0
      //   2988: getfield 26	com/tencent/mm/aj/d$b:iKq	Lcom/tencent/mm/aj/i;
      //   2991: invokevirtual 199	com/tencent/mm/aj/i:getUsername	()Ljava/lang/String;
      //   2994: aastore
      //   2995: dup
      //   2996: iconst_5
      //   2997: aload 15
      //   2999: invokeinterface 298 1 0
      //   3004: aastore
      //   3005: dup
      //   3006: bipush 6
      //   3008: aload 15
      //   3010: invokeinterface 301 1 0
      //   3015: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   3018: aastore
      //   3019: dup
      //   3020: bipush 7
      //   3022: aload 15
      //   3024: invokeinterface 304 1 0
      //   3029: aastore
      //   3030: dup
      //   3031: bipush 8
      //   3033: aload 27
      //   3035: aastore
      //   3036: dup
      //   3037: bipush 9
      //   3039: ldc_w 295
      //   3042: aastore
      //   3043: invokevirtual 307	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
      //   3046: aload 16
      //   3048: astore 19
      //   3050: aload 15
      //   3052: astore 20
      //   3054: aload 16
      //   3056: astore 21
      //   3058: aload 15
      //   3060: astore 22
      //   3062: aload 16
      //   3064: astore 23
      //   3066: aload 15
      //   3068: astore 24
      //   3070: aload 16
      //   3072: astore 25
      //   3074: aload 15
      //   3076: astore 26
      //   3078: aload_0
      //   3079: aload 16
      //   3081: invokevirtual 401	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   3084: putfield 28	com/tencent/mm/aj/d$b:iKr	[B
      //   3087: aload 16
      //   3089: astore 19
      //   3091: aload 15
      //   3093: astore 20
      //   3095: aload 16
      //   3097: astore 21
      //   3099: aload 15
      //   3101: astore 22
      //   3103: aload 16
      //   3105: astore 23
      //   3107: aload 15
      //   3109: astore 24
      //   3111: aload 16
      //   3113: astore 25
      //   3115: aload 15
      //   3117: astore 26
      //   3119: aload 16
      //   3121: invokevirtual 341	java/io/ByteArrayOutputStream:close	()V
      //   3124: aconst_null
      //   3125: astore 18
      //   3127: aconst_null
      //   3128: astore 28
      //   3130: aconst_null
      //   3131: astore 29
      //   3133: aconst_null
      //   3134: astore 30
      //   3136: aconst_null
      //   3137: astore 35
      //   3139: aconst_null
      //   3140: astore 36
      //   3142: aconst_null
      //   3143: astore 37
      //   3145: aconst_null
      //   3146: astore 38
      //   3148: aconst_null
      //   3149: astore 16
      //   3151: aload 35
      //   3153: astore 19
      //   3155: aload 15
      //   3157: astore 20
      //   3159: aload 36
      //   3161: astore 21
      //   3163: aload 15
      //   3165: astore 22
      //   3167: aload 37
      //   3169: astore 23
      //   3171: aload 15
      //   3173: astore 24
      //   3175: aload 38
      //   3177: astore 25
      //   3179: aload 15
      //   3181: astore 26
      //   3183: aload 15
      //   3185: invokeinterface 335 1 0
      //   3190: aconst_null
      //   3191: astore 34
      //   3193: aconst_null
      //   3194: astore 31
      //   3196: aconst_null
      //   3197: astore 32
      //   3199: aconst_null
      //   3200: astore 33
      //   3202: aconst_null
      //   3203: astore 20
      //   3205: aconst_null
      //   3206: astore 22
      //   3208: aconst_null
      //   3209: astore 24
      //   3211: aconst_null
      //   3212: astore 26
      //   3214: aconst_null
      //   3215: astore 15
      //   3217: aload 35
      //   3219: astore 19
      //   3221: aload 36
      //   3223: astore 21
      //   3225: aload 37
      //   3227: astore 23
      //   3229: aload 38
      //   3231: astore 25
      //   3233: aload 17
      //   3235: invokevirtual 340	java/io/InputStream:close	()V
      //   3238: iload_1
      //   3239: ifle +34 -> 3273
      //   3242: aload_0
      //   3243: getfield 28	com/tencent/mm/aj/d$b:iKr	[B
      //   3246: arraylength
      //   3247: iload_1
      //   3248: if_icmpge +25 -> 3273
      //   3251: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   3254: ldc2_w 207
      //   3257: ldc2_w 402
      //   3260: lconst_1
      //   3261: iconst_1
      //   3262: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   3265: ldc 65
      //   3267: ldc_w 405
      //   3270: invokestatic 407	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   3273: aconst_null
      //   3274: astore 16
      //   3276: aload 18
      //   3278: astore 17
      //   3280: aload 34
      //   3282: astore 15
      //   3284: goto -1910 -> 1374
      //   3287: aload 15
      //   3289: invokeinterface 298 1 0
      //   3294: astore 19
      //   3296: goto -2064 -> 1232
      //   3299: aload 15
      //   3301: invokeinterface 301 1 0
      //   3306: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   3309: astore 20
      //   3311: goto -2069 -> 1242
      //   3314: aload 15
      //   3316: invokeinterface 304 1 0
      //   3321: astore 21
      //   3323: goto -2071 -> 1252
      //   3326: aload 15
      //   3328: invokeinterface 298 1 0
      //   3333: astore 16
      //   3335: goto -1657 -> 1678
      //   3338: aload 15
      //   3340: invokeinterface 301 1 0
      //   3345: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   3348: astore 20
      //   3350: goto -1662 -> 1688
      //   3353: aload 15
      //   3355: invokeinterface 304 1 0
      //   3360: astore 21
      //   3362: goto -1664 -> 1698
      //   3365: aload 15
      //   3367: invokeinterface 298 1 0
      //   3372: astore 16
      //   3374: goto -1343 -> 2031
      //   3377: aload 15
      //   3379: invokeinterface 301 1 0
      //   3384: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   3387: astore 20
      //   3389: goto -1348 -> 2041
      //   3392: aload 15
      //   3394: invokeinterface 304 1 0
      //   3399: astore 21
      //   3401: goto -1350 -> 2051
      //   3404: aload 15
      //   3406: invokeinterface 298 1 0
      //   3411: astore 16
      //   3413: goto -1031 -> 2382
      //   3416: aload 15
      //   3418: invokeinterface 301 1 0
      //   3423: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   3426: astore 20
      //   3428: goto -1036 -> 2392
      //   3431: aload 15
      //   3433: invokeinterface 304 1 0
      //   3438: astore 21
      //   3440: goto -1038 -> 2402
      //   3443: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   3446: ldc2_w 241
      //   3449: ldc2_w 408
      //   3452: lload 5
      //   3454: iconst_0
      //   3455: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   3458: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   3461: ldc2_w 241
      //   3464: ldc2_w 410
      //   3467: lconst_1
      //   3468: iconst_0
      //   3469: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   3472: ldc 65
      //   3474: ldc_w 413
      //   3477: lload 5
      //   3479: invokestatic 350	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   3482: invokevirtual 354	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   3485: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   3488: goto -2025 -> 1463
      //   3491: astore 15
      //   3493: ldc 65
      //   3495: ldc_w 415
      //   3498: iconst_1
      //   3499: anewarray 4	java/lang/Object
      //   3502: dup
      //   3503: iconst_0
      //   3504: aload 15
      //   3506: invokestatic 421	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   3509: aastore
      //   3510: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3513: ldc 65
      //   3515: ldc_w 423
      //   3518: iconst_1
      //   3519: anewarray 4	java/lang/Object
      //   3522: dup
      //   3523: iconst_0
      //   3524: aload 15
      //   3526: invokevirtual 367	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   3529: aastore
      //   3530: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3533: getstatic 135	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   3536: ldc2_w 207
      //   3539: ldc2_w 424
      //   3542: lconst_1
      //   3543: iconst_1
      //   3544: invokevirtual 214	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   3547: goto -2084 -> 1463
      //   3550: astore 17
      //   3552: iconst_0
      //   3553: istore_3
      //   3554: lload 7
      //   3556: lstore 5
      //   3558: aload 25
      //   3560: astore 18
      //   3562: aload 16
      //   3564: astore 19
      //   3566: aload 26
      //   3568: astore 15
      //   3570: goto -1231 -> 2339
      //   3573: astore 17
      //   3575: aload 25
      //   3577: astore 18
      //   3579: aload 16
      //   3581: astore 19
      //   3583: goto -1244 -> 2339
      //   3586: astore 17
      //   3588: aload 25
      //   3590: astore 18
      //   3592: aload 16
      //   3594: astore 19
      //   3596: goto -1257 -> 2339
      //   3599: astore 15
      //   3601: aload 17
      //   3603: astore 18
      //   3605: aload 15
      //   3607: astore 17
      //   3609: aload 20
      //   3611: astore 15
      //   3613: goto -1274 -> 2339
      //   3616: astore 17
      //   3618: aconst_null
      //   3619: astore 18
      //   3621: aload 30
      //   3623: astore 19
      //   3625: aload 33
      //   3627: astore 15
      //   3629: goto -1290 -> 2339
      //   3632: astore 17
      //   3634: iconst_0
      //   3635: istore_3
      //   3636: lload 9
      //   3638: lstore 5
      //   3640: aload 24
      //   3642: astore 18
      //   3644: aload 16
      //   3646: astore 19
      //   3648: aload 21
      //   3650: astore 15
      //   3652: goto -1666 -> 1986
      //   3655: astore 17
      //   3657: aload 24
      //   3659: astore 18
      //   3661: aload 16
      //   3663: astore 19
      //   3665: goto -1679 -> 1986
      //   3668: astore 17
      //   3670: aload 24
      //   3672: astore 18
      //   3674: aload 16
      //   3676: astore 19
      //   3678: goto -1692 -> 1986
      //   3681: astore 15
      //   3683: aload 17
      //   3685: astore 18
      //   3687: aload 15
      //   3689: astore 17
      //   3691: aload 21
      //   3693: astore 19
      //   3695: aload 22
      //   3697: astore 15
      //   3699: goto -1713 -> 1986
      //   3702: astore 17
      //   3704: aconst_null
      //   3705: astore 18
      //   3707: aload 29
      //   3709: astore 19
      //   3711: aload 32
      //   3713: astore 15
      //   3715: goto -1729 -> 1986
      //   3718: astore 17
      //   3720: iconst_0
      //   3721: istore_3
      //   3722: lload 11
      //   3724: lstore 5
      //   3726: aload 23
      //   3728: astore 18
      //   3730: aload 16
      //   3732: astore 19
      //   3734: aload 20
      //   3736: astore 15
      //   3738: goto -2105 -> 1633
      //   3741: astore 17
      //   3743: aload 23
      //   3745: astore 18
      //   3747: aload 16
      //   3749: astore 19
      //   3751: goto -2118 -> 1633
      //   3754: astore 17
      //   3756: aload 23
      //   3758: astore 18
      //   3760: aload 16
      //   3762: astore 19
      //   3764: goto -2131 -> 1633
      //   3767: astore 15
      //   3769: aload 17
      //   3771: astore 18
      //   3773: aload 15
      //   3775: astore 17
      //   3777: aload 23
      //   3779: astore 19
      //   3781: aload 24
      //   3783: astore 15
      //   3785: goto -2152 -> 1633
      //   3788: astore 17
      //   3790: aconst_null
      //   3791: astore 18
      //   3793: aload 28
      //   3795: astore 19
      //   3797: aload 31
      //   3799: astore 15
      //   3801: goto -2168 -> 1633
      //   3804: astore 17
      //   3806: iconst_0
      //   3807: istore_3
      //   3808: lload 13
      //   3810: lstore 5
      //   3812: aload 22
      //   3814: astore 18
      //   3816: goto -2627 -> 1189
      //   3819: astore 17
      //   3821: aload 22
      //   3823: astore 18
      //   3825: goto -2636 -> 1189
      //   3828: astore 17
      //   3830: aload 22
      //   3832: astore 18
      //   3834: goto -2645 -> 1189
      //   3837: astore 17
      //   3839: aconst_null
      //   3840: astore 18
      //   3842: goto -2653 -> 1189
      //   3845: ldc_w 295
      //   3848: astore 17
      //   3850: goto -3612 -> 238
      //   3853: goto -3710 -> 143
      //   3856: goto -3052 -> 804
      //   3859: astore 15
      //   3861: aload 17
      //   3863: astore 18
      //   3865: aload 15
      //   3867: astore 17
      //   3869: aload 25
      //   3871: astore 16
      //   3873: aload 26
      //   3875: astore 15
      //   3877: goto -2688 -> 1189
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	3880	0	this	b
      //   182	3067	1	i	int
      //   2777	44	2	j	int
      //   60	3748	3	bool1	boolean
      //   78	2617	4	bool2	boolean
      //   315	3496	5	l1	long
      //   333	3222	7	l2	long
      //   337	3300	9	l3	long
      //   341	3382	11	l4	long
      //   345	3464	13	l5	long
      //   126	3306	15	localObject1	Object
      //   3491	34	15	localException1	Exception
      //   3568	1	15	localObject2	Object
      //   3599	7	15	localException2	Exception
      //   3611	40	15	localObject3	Object
      //   3681	7	15	localIOException1	java.io.IOException
      //   3697	40	15	localObject4	Object
      //   3767	7	15	localSocketTimeoutException1	java.net.SocketTimeoutException
      //   3783	17	15	localObject5	Object
      //   3859	7	15	localProtocolException1	java.net.ProtocolException
      //   3875	1	15	localObject6	Object
      //   300	3572	16	localObject7	Object
      //   236	935	17	localObject8	Object
      //   1179	179	17	localProtocolException2	java.net.ProtocolException
      //   1368	243	17	localObject9	Object
      //   1619	185	17	localSocketTimeoutException2	java.net.SocketTimeoutException
      //   1818	146	17	localObject10	Object
      //   1972	185	17	localIOException2	java.io.IOException
      //   2171	146	17	localObject11	Object
      //   2325	183	17	localException3	Exception
      //   2522	757	17	localObject12	Object
      //   3550	1	17	localException4	Exception
      //   3573	1	17	localException5	Exception
      //   3586	16	17	localException6	Exception
      //   3607	1	17	localException7	Exception
      //   3616	1	17	localException8	Exception
      //   3632	1	17	localIOException3	java.io.IOException
      //   3655	1	17	localIOException4	java.io.IOException
      //   3668	16	17	localIOException5	java.io.IOException
      //   3689	1	17	localIOException6	java.io.IOException
      //   3702	1	17	localIOException7	java.io.IOException
      //   3718	1	17	localSocketTimeoutException3	java.net.SocketTimeoutException
      //   3741	1	17	localSocketTimeoutException4	java.net.SocketTimeoutException
      //   3754	16	17	localSocketTimeoutException5	java.net.SocketTimeoutException
      //   3775	1	17	localSocketTimeoutException6	java.net.SocketTimeoutException
      //   3788	1	17	localSocketTimeoutException7	java.net.SocketTimeoutException
      //   3804	1	17	localProtocolException3	java.net.ProtocolException
      //   3819	1	17	localProtocolException4	java.net.ProtocolException
      //   3828	1	17	localProtocolException5	java.net.ProtocolException
      //   3837	1	17	localProtocolException6	java.net.ProtocolException
      //   3848	20	17	localObject13	Object
      //   291	3573	18	localObject14	Object
      //   273	3523	19	localObject15	Object
      //   276	3459	20	localObject16	Object
      //   282	3410	21	localObject17	Object
      //   312	3519	22	localObject18	Object
      //   303	3475	23	localObject19	Object
      //   306	3476	24	localObject20	Object
      //   309	3561	25	localObject21	Object
      //   288	3586	26	localObject22	Object
      //   45	2989	27	localObject23	Object
      //   285	3509	28	localObject24	Object
      //   279	3429	29	localObject25	Object
      //   3134	488	30	localObject26	Object
      //   3194	604	31	localObject27	Object
      //   3197	515	32	localObject28	Object
      //   3200	426	33	localObject29	Object
      //   3191	90	34	localObject30	Object
      //   3137	81	35	localObject31	Object
      //   3140	82	36	localObject32	Object
      //   3143	83	37	localObject33	Object
      //   3146	84	38	localObject34	Object
      // Exception table:
      //   from	to	target	type
      //   398	405	1179	java/net/ProtocolException
      //   475	484	1179	java/net/ProtocolException
      //   500	511	1179	java/net/ProtocolException
      //   527	537	1179	java/net/ProtocolException
      //   553	563	1179	java/net/ProtocolException
      //   579	587	1179	java/net/ProtocolException
      //   610	619	1179	java/net/ProtocolException
      //   640	655	1179	java/net/ProtocolException
      //   676	686	1179	java/net/ProtocolException
      //   702	715	1179	java/net/ProtocolException
      //   731	760	1179	java/net/ProtocolException
      //   820	834	1179	java/net/ProtocolException
      //   850	950	1179	java/net/ProtocolException
      //   991	999	1179	java/net/ProtocolException
      //   1046	1060	1179	java/net/ProtocolException
      //   1076	1176	1179	java/net/ProtocolException
      //   1486	1500	1179	java/net/ProtocolException
      //   1516	1616	1179	java/net/ProtocolException
      //   1839	1853	1179	java/net/ProtocolException
      //   1869	1969	1179	java/net/ProtocolException
      //   2192	2206	1179	java/net/ProtocolException
      //   2222	2322	1179	java/net/ProtocolException
      //   2543	2558	1179	java/net/ProtocolException
      //   2577	2583	1179	java/net/ProtocolException
      //   2599	2607	1179	java/net/ProtocolException
      //   2623	2632	1179	java/net/ProtocolException
      //   398	405	1619	java/net/SocketTimeoutException
      //   475	484	1619	java/net/SocketTimeoutException
      //   500	511	1619	java/net/SocketTimeoutException
      //   527	537	1619	java/net/SocketTimeoutException
      //   553	563	1619	java/net/SocketTimeoutException
      //   579	587	1619	java/net/SocketTimeoutException
      //   610	619	1619	java/net/SocketTimeoutException
      //   640	655	1619	java/net/SocketTimeoutException
      //   676	686	1619	java/net/SocketTimeoutException
      //   702	715	1619	java/net/SocketTimeoutException
      //   731	760	1619	java/net/SocketTimeoutException
      //   820	834	1619	java/net/SocketTimeoutException
      //   850	950	1619	java/net/SocketTimeoutException
      //   991	999	1619	java/net/SocketTimeoutException
      //   1046	1060	1619	java/net/SocketTimeoutException
      //   1076	1176	1619	java/net/SocketTimeoutException
      //   1486	1500	1619	java/net/SocketTimeoutException
      //   1516	1616	1619	java/net/SocketTimeoutException
      //   1839	1853	1619	java/net/SocketTimeoutException
      //   1869	1969	1619	java/net/SocketTimeoutException
      //   2192	2206	1619	java/net/SocketTimeoutException
      //   2222	2322	1619	java/net/SocketTimeoutException
      //   2543	2558	1619	java/net/SocketTimeoutException
      //   2577	2583	1619	java/net/SocketTimeoutException
      //   2599	2607	1619	java/net/SocketTimeoutException
      //   2623	2632	1619	java/net/SocketTimeoutException
      //   398	405	1972	java/io/IOException
      //   475	484	1972	java/io/IOException
      //   500	511	1972	java/io/IOException
      //   527	537	1972	java/io/IOException
      //   553	563	1972	java/io/IOException
      //   579	587	1972	java/io/IOException
      //   610	619	1972	java/io/IOException
      //   640	655	1972	java/io/IOException
      //   676	686	1972	java/io/IOException
      //   702	715	1972	java/io/IOException
      //   731	760	1972	java/io/IOException
      //   820	834	1972	java/io/IOException
      //   850	950	1972	java/io/IOException
      //   991	999	1972	java/io/IOException
      //   1046	1060	1972	java/io/IOException
      //   1076	1176	1972	java/io/IOException
      //   1486	1500	1972	java/io/IOException
      //   1516	1616	1972	java/io/IOException
      //   1839	1853	1972	java/io/IOException
      //   1869	1969	1972	java/io/IOException
      //   2192	2206	1972	java/io/IOException
      //   2222	2322	1972	java/io/IOException
      //   2543	2558	1972	java/io/IOException
      //   2577	2583	1972	java/io/IOException
      //   2599	2607	1972	java/io/IOException
      //   2623	2632	1972	java/io/IOException
      //   398	405	2325	java/lang/Exception
      //   475	484	2325	java/lang/Exception
      //   500	511	2325	java/lang/Exception
      //   527	537	2325	java/lang/Exception
      //   553	563	2325	java/lang/Exception
      //   579	587	2325	java/lang/Exception
      //   610	619	2325	java/lang/Exception
      //   640	655	2325	java/lang/Exception
      //   676	686	2325	java/lang/Exception
      //   702	715	2325	java/lang/Exception
      //   731	760	2325	java/lang/Exception
      //   820	834	2325	java/lang/Exception
      //   850	950	2325	java/lang/Exception
      //   991	999	2325	java/lang/Exception
      //   1046	1060	2325	java/lang/Exception
      //   1076	1176	2325	java/lang/Exception
      //   1486	1500	2325	java/lang/Exception
      //   1516	1616	2325	java/lang/Exception
      //   1839	1853	2325	java/lang/Exception
      //   1869	1969	2325	java/lang/Exception
      //   2192	2206	2325	java/lang/Exception
      //   2222	2322	2325	java/lang/Exception
      //   2543	2558	2325	java/lang/Exception
      //   2577	2583	2325	java/lang/Exception
      //   2599	2607	2325	java/lang/Exception
      //   2623	2632	2325	java/lang/Exception
      //   1379	1386	3491	java/lang/Exception
      //   1391	1396	3491	java/lang/Exception
      //   1401	1406	3491	java/lang/Exception
      //   1406	1414	3491	java/lang/Exception
      //   1418	1463	3491	java/lang/Exception
      //   3443	3488	3491	java/lang/Exception
      //   347	352	3550	java/lang/Exception
      //   368	386	3550	java/lang/Exception
      //   405	459	3573	java/lang/Exception
      //   999	1013	3586	java/lang/Exception
      //   2669	2686	3599	java/lang/Exception
      //   2731	2738	3599	java/lang/Exception
      //   2770	2778	3599	java/lang/Exception
      //   2815	2824	3599	java/lang/Exception
      //   2859	2873	3599	java/lang/Exception
      //   2905	2911	3599	java/lang/Exception
      //   2943	3046	3599	java/lang/Exception
      //   3078	3087	3599	java/lang/Exception
      //   3119	3124	3599	java/lang/Exception
      //   3183	3190	3599	java/lang/Exception
      //   3233	3238	3599	java/lang/Exception
      //   3242	3273	3616	java/lang/Exception
      //   347	352	3632	java/io/IOException
      //   368	386	3632	java/io/IOException
      //   405	459	3655	java/io/IOException
      //   999	1013	3668	java/io/IOException
      //   2669	2686	3681	java/io/IOException
      //   2731	2738	3681	java/io/IOException
      //   2770	2778	3681	java/io/IOException
      //   2815	2824	3681	java/io/IOException
      //   2859	2873	3681	java/io/IOException
      //   2905	2911	3681	java/io/IOException
      //   2943	3046	3681	java/io/IOException
      //   3078	3087	3681	java/io/IOException
      //   3119	3124	3681	java/io/IOException
      //   3183	3190	3681	java/io/IOException
      //   3233	3238	3681	java/io/IOException
      //   3242	3273	3702	java/io/IOException
      //   347	352	3718	java/net/SocketTimeoutException
      //   368	386	3718	java/net/SocketTimeoutException
      //   405	459	3741	java/net/SocketTimeoutException
      //   999	1013	3754	java/net/SocketTimeoutException
      //   2669	2686	3767	java/net/SocketTimeoutException
      //   2731	2738	3767	java/net/SocketTimeoutException
      //   2770	2778	3767	java/net/SocketTimeoutException
      //   2815	2824	3767	java/net/SocketTimeoutException
      //   2859	2873	3767	java/net/SocketTimeoutException
      //   2905	2911	3767	java/net/SocketTimeoutException
      //   2943	3046	3767	java/net/SocketTimeoutException
      //   3078	3087	3767	java/net/SocketTimeoutException
      //   3119	3124	3767	java/net/SocketTimeoutException
      //   3183	3190	3767	java/net/SocketTimeoutException
      //   3233	3238	3767	java/net/SocketTimeoutException
      //   3242	3273	3788	java/net/SocketTimeoutException
      //   347	352	3804	java/net/ProtocolException
      //   368	386	3804	java/net/ProtocolException
      //   405	459	3819	java/net/ProtocolException
      //   999	1013	3828	java/net/ProtocolException
      //   3242	3273	3837	java/net/ProtocolException
      //   2669	2686	3859	java/net/ProtocolException
      //   2731	2738	3859	java/net/ProtocolException
      //   2770	2778	3859	java/net/ProtocolException
      //   2815	2824	3859	java/net/ProtocolException
      //   2859	2873	3859	java/net/ProtocolException
      //   2905	2911	3859	java/net/ProtocolException
      //   2943	3046	3859	java/net/ProtocolException
      //   3078	3087	3859	java/net/ProtocolException
      //   3119	3124	3859	java/net/ProtocolException
      //   3183	3190	3859	java/net/ProtocolException
      //   3233	3238	3859	java/net/ProtocolException
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150221);
      if ((this.iKq == null) || (Util.isNullOrNil(this.iKq.getUsername())))
      {
        AppMethodBeat.o(150221);
        return false;
      }
      if (Util.isNullOrNil(this.iKr))
      {
        d.this.iKc.remove(this.iKq.getUsername());
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(138L, 10L, 1L, true);
        AppMethodBeat.o(150221);
        return false;
      }
      if (ay.a.iDr != null) {
        ay.a.iDr.dl(this.iKr.length, 0);
      }
      d.this.a(new d.a(d.this, this.iKq, this.iKr, this.bGA));
      AppMethodBeat.o(150221);
      return false;
    }
  }
  
  final class c
    implements QueueWorkerThread.ThreadObject
  {
    Bitmap iKs = null;
    b iKt = null;
    String username = null;
    
    public c(String paramString)
    {
      this.username = paramString;
    }
    
    public c(String paramString, b paramb)
    {
      this.username = paramString;
      this.iKt = paramb;
    }
    
    public final boolean doInBackground()
    {
      Context localContext = null;
      Object localObject1 = null;
      int i = 0;
      AppMethodBeat.i(150222);
      if (Util.isNullOrNil(this.username))
      {
        AppMethodBeat.o(150222);
        return false;
      }
      String str1 = this.username;
      boolean bool;
      String str2;
      Object localObject2;
      if (str1 == null)
      {
        bool = false;
        if (bool)
        {
          str2 = (String)d.this.iKi.get(str1);
          if (!Util.isNullOrNil(str2))
          {
            localObject2 = p.aYB().Mx(str1);
            if ((localObject2 == null) || (!str1.equals(((i)localObject2).getUsername())))
            {
              localObject2 = p.aYB();
              String str3 = "select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + Util.escapeSqlValue(str2) + "\"";
              localObject2 = ((j)localObject2).iFy.rawQuery(str3, null, 2);
              if (localObject2 != null) {
                break label263;
              }
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && (!Util.isNullOrNil(((i)localObject1).getUsername()))) {
          s.nw(c.Me(((i)localObject1).getUsername()), c.Me(str1));
        }
        localObject1 = new i();
        ((i)localObject1).username = str1;
        ((i)localObject1).fuz = 3;
        ((i)localObject1).iKW = str2;
        ((i)localObject1).iKX = str2;
        ((i)localObject1).cSx = 3;
        ((i)localObject1).fv(true);
        ((i)localObject1).cSx = 31;
        p.aYB().b((i)localObject1);
        localObject1 = d.aYn();
        if (localObject1 != null) {
          break label308;
        }
        AppMethodBeat.o(150222);
        return false;
        bool = str1.startsWith("ammURL_");
        break;
        label263:
        localObject1 = localContext;
        if (((Cursor)localObject2).moveToFirst())
        {
          ((Cursor)localObject2).moveToFirst();
          localObject1 = new i();
          ((i)localObject1).convertFrom((Cursor)localObject2);
        }
        ((Cursor)localObject2).close();
      }
      label308:
      if (e.iKw.containsKey(this.username)) {
        i = ((Integer)e.iKw.get(this.username)).intValue();
      }
      if (i != 0)
      {
        p.aYA();
        localContext = p.getContext();
        if (localContext != null) {
          ((e)localObject1).e(this.username, com.tencent.mm.compatible.f.a.decodeResource(localContext.getResources(), i));
        }
      }
      this.iKs = e.Mn(this.username);
      AppMethodBeat.o(150222);
      return true;
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150223);
      if (this.iKs == null)
      {
        d locald = d.this;
        String str = this.username;
        b localb = this.iKt;
        Log.d("MicroMsg.AvatarService", "avatar service push: %s", new Object[] { str });
        if (Util.isNullOrNil(str))
        {
          localObject = null;
          if (localObject != null) {
            break label481;
          }
          locald.iKc.remove(str);
        }
        for (;;)
        {
          AppMethodBeat.o(150223);
          return false;
          if ((str.equals(locald.iKh + "@bottle")) && (!Util.nullAs((Boolean)g.aAh().azQ().get(60, null), false)))
          {
            localObject = null;
            break;
          }
          if ((str.equals(locald.iKh)) && (!Util.nullAs((Boolean)g.aAh().azQ().get(59, null), false)))
          {
            Log.w("MicroMsg.AvatarService", "ConstantsStorage.USERINFO_HAS_HEADIMG false");
            localObject = null;
            break;
          }
          long l = Util.nowSecond();
          d.d locald1 = (d.d)locald.iKd.aT(str);
          if ((locald1 != null) && (locald1.ibG >= 5) && (l - locald1.hwQ < 600L))
          {
            Log.w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", new Object[] { str });
            localObject = null;
            break;
          }
          localObject = d.Mi(str);
          if (localObject == null)
          {
            Log.w("MicroMsg.AvatarService", "checkUser block local no need: %s", new Object[] { str });
            localObject = new d.d((byte)0);
            ((d.d)localObject).ibG = 5;
            ((d.d)localObject).hwQ = l;
            locald.iKd.x(str, localObject);
            localObject = null;
            break;
          }
          if ((locald1 == null) || (l - locald1.hwQ > 600L))
          {
            Log.i("MicroMsg.AvatarService", "new user: %s", new Object[] { str });
            locald1 = new d.d((byte)0);
            locald1.ibG = 1;
            locald1.hwQ = l;
            locald.iKd.x(str, locald1);
          }
          for (;;)
          {
            break;
            if (locald1.ibG < 5)
            {
              Log.i("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", new Object[] { str, Integer.valueOf(locald1.ibG), Long.valueOf(l - locald1.hwQ) });
              locald1.ibG += 1;
              locald1.hwQ = l;
              locald.iKd.x(str, locald1);
            }
          }
          label481:
          if (!Util.isNullOrNil(((i)localObject).aYu()))
          {
            locald.a(new d.b(locald, (i)localObject));
          }
          else
          {
            Log.w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", new Object[] { str, Integer.valueOf(((i)localObject).fuz) });
            if (4 == ((i)localObject).fuz)
            {
              Log.w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
            }
            else if ((localb != null) && (!localb.iJY))
            {
              Log.w("MicroMsg.AvatarService", "avatar push username %s can not get avatar by username", new Object[] { str });
              locald.iKc.remove(str);
            }
            else
            {
              locald.iKe.push(localObject);
              if (locald.iKe.size() > 5) {
                locald.iKj.startTimer(0L);
              } else {
                locald.iKj.startTimer(1000L);
              }
            }
          }
        }
      }
      Object localObject = d.aYn();
      if (localObject != null) {
        ((e)localObject).d(this.username, this.iKs);
      }
      d.this.iKc.remove(this.username);
      AppMethodBeat.o(150223);
      return false;
    }
  }
  
  static final class d
  {
    public long hwQ = 0L;
    public int ibG = 0;
  }
  
  final class e
    implements QueueWorkerThread.ThreadObject
  {
    Bitmap bitmap = null;
    byte[] buf;
    i iKn = null;
    
    public e(i parami, byte[] paramArrayOfByte)
    {
      this.iKn = parami;
      this.buf = paramArrayOfByte;
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(150224);
      if ((this.iKn == null) || (Util.isNullOrNil(this.iKn.getUsername())))
      {
        Log.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(138L, 13L, 1L, true);
        AppMethodBeat.o(150224);
        return false;
      }
      if (d.aYn() != null)
      {
        e.N(this.iKn.getUsername(), false);
        e.N(this.iKn.getUsername(), true);
        this.bitmap = e.g(this.iKn.getUsername(), this.buf);
        if (this.bitmap == null) {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(138L, 14L, 1L, true);
        }
      }
      for (;;)
      {
        j localj = d.aYo();
        if (localj != null)
        {
          this.iKn.cSx = -1;
          this.iKn.aYv();
          localj.b(this.iKn);
        }
        AppMethodBeat.o(150224);
        return true;
        Log.i("MicroMsg.AvatarService", "astg is null!!");
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150225);
      if (Util.isNullOrNil(this.iKn.getUsername()))
      {
        AppMethodBeat.o(150225);
        return false;
      }
      e locale = d.aYn();
      if ((locale != null) && (this.bitmap != null)) {
        locale.d(this.iKn.getUsername(), this.bitmap);
      }
      d.this.iKc.remove(this.iKn.getUsername());
      AppMethodBeat.o(150225);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.d
 * JD-Core Version:    0.7.0.1
 */