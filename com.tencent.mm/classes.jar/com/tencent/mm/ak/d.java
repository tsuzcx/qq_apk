package com.tencent.mm.ak;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.au;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.e;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bhm;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bg;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class d
  implements com.tencent.mm.al.g
{
  boolean gTk;
  Set<String> gTl;
  com.tencent.mm.b.f<String, d> gTm;
  Stack<i> gTn;
  private be gTo;
  private be gTp;
  String gTq;
  com.tencent.mm.b.f<String, String> gTr;
  av gTs;
  
  public d()
  {
    AppMethodBeat.i(150226);
    this.gTk = false;
    this.gTl = Collections.synchronizedSet(new HashSet());
    this.gTm = new com.tencent.mm.memory.a.c(400);
    this.gTn = new Stack();
    this.gTo = null;
    this.gTp = null;
    this.gTq = null;
    this.gTr = new com.tencent.mm.memory.a.c(200);
    this.gTs = new av(Looper.getMainLooper(), new av.a()
    {
      private long gTv = 0L;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150217);
        long l = System.currentTimeMillis();
        if ((d.this.gTk) && (l - this.gTv > 60000L))
        {
          ad.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", new Object[] { Long.valueOf(l - this.gTv) });
          d.this.gTk = false;
        }
        if (d.this.gTk)
        {
          d.this.gTs.av(1000L, 1000L);
          AppMethodBeat.o(150217);
          return false;
        }
        this.gTv = l;
        d.this.gTk = true;
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while ((i < 5) && (d.this.gTn.size() > 0))
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(138L, 42L, 1L, true);
          localLinkedList.add(new cmf().aEE(bt.nullAsNil(((i)d.this.gTn.pop()).getUsername())));
          i += 1;
        }
        com.tencent.mm.kernel.g.aeS().a(new k(localLinkedList), 0);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(138L, 44L, 1L, true);
        AppMethodBeat.o(150217);
        return false;
      }
    }, false);
    com.tencent.mm.kernel.g.aeS().a(123, this);
    this.gTk = false;
    this.gTq = u.aqG();
    AppMethodBeat.o(150226);
  }
  
  static e auq()
  {
    AppMethodBeat.i(150234);
    if (com.tencent.mm.kernel.g.afz().aeI())
    {
      e locale = p.auq();
      AppMethodBeat.o(150234);
      return locale;
    }
    AppMethodBeat.o(150234);
    return null;
  }
  
  static i vR(String paramString)
  {
    AppMethodBeat.i(150230);
    Object localObject1 = p.auF().we(paramString);
    if ((localObject1 != null) && (((i)localObject1).getUsername().equals(paramString)))
    {
      ad.i("MicroMsg.AvatarService", "[isFlagNeed] getSmallUrl:%s username:%s", new Object[] { ((i)localObject1).auy(), paramString });
      AppMethodBeat.o(150230);
      return localObject1;
    }
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
    if (((au)localObject1).evo == 4)
    {
      c.ac(paramString, ((au)localObject1).evo);
      ad.d("MicroMsg.AvatarService", "ct imgFlag :%s", new Object[] { Integer.valueOf(((au)localObject1).evo) });
      AppMethodBeat.o(150230);
      return null;
    }
    localObject1 = new i();
    ((i)localObject1).username = paramString;
    ((i)localObject1).evo = 3;
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aId(paramString);
    if (bt.cw((byte[])localObject2))
    {
      ad.i("MicroMsg.AvatarService", "[isFlagNeed] cmdBuf is null! username:%s", new Object[] { paramString });
      AppMethodBeat.o(150230);
      return localObject1;
    }
    try
    {
      localObject2 = c.a(paramString, (bqj)new bqj().parseFrom((byte[])localObject2));
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AvatarService", "exception:%s", new Object[] { bt.m(localException) });
      }
    }
    ad.i("MicroMsg.AvatarService", "[isFlagNeed] finally! getSmallUrl:%s getBigUrl:%s username:%s", new Object[] { ((i)localObject1).auy(), ((i)localObject1).aux(), paramString });
    AppMethodBeat.o(150230);
    return localObject1;
  }
  
  final int a(final be.a parama)
  {
    AppMethodBeat.i(150232);
    com.tencent.e.h.Iye.aP(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "AvatarService#putAsyncTask";
      }
      
      public final void run()
      {
        AppMethodBeat.i(150216);
        parama.aus();
        parama.aut();
        AppMethodBeat.o(150216);
      }
    });
    AppMethodBeat.o(150232);
    return 1;
  }
  
  public final Bitmap b(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(190711);
    e locale = auq();
    Bitmap localBitmap2;
    if (locale != null) {
      if ((paramInt >= 0) && (paramInt > 5))
      {
        localBitmap2 = e.vT(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
        if (localBitmap2 != null)
        {
          ad.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
          AppMethodBeat.o(190711);
          return localBitmap2;
        }
        ad.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
        localBitmap1 = localBitmap2;
        if (localBitmap2 != null) {}
      }
    }
    for (Bitmap localBitmap1 = e.vT(paramString);; localBitmap1 = null)
    {
      if (localBitmap1 != null)
      {
        paramb = localBitmap1;
        if (paramInt >= 0)
        {
          paramb = localBitmap1;
          if (paramInt > 5)
          {
            ad.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", new Object[] { Integer.valueOf(paramInt) });
            paramb = com.tencent.mm.sdk.platformtools.f.a(localBitmap1, false, paramInt);
            locale.e(String.format("%s$$%d", new Object[] { paramString, Integer.valueOf(paramInt) }), paramb);
          }
        }
        AppMethodBeat.o(190711);
        return paramb;
      }
      if (paramBoolean)
      {
        AppMethodBeat.o(190711);
        return null;
      }
      ad.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", new Object[] { paramString });
      if (this.gTl.contains(paramString))
      {
        AppMethodBeat.o(190711);
        return null;
      }
      this.gTl.add(paramString);
      a(new c(paramString, paramb));
      AppMethodBeat.o(190711);
      return null;
      localBitmap2 = null;
      break;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150231);
    while (this.gTn.size() > 0) {
      this.gTl.remove(this.gTn.pop());
    }
    AppMethodBeat.o(150231);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(150233);
    if (paramn == null)
    {
      AppMethodBeat.o(150233);
      return;
    }
    if (paramn.getType() != 123)
    {
      AppMethodBeat.o(150233);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(138L, 12L, 1L, true);
    }
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(138L, 45L, 1L, true);
    Object localObject;
    bhm localbhm;
    try
    {
      paramn = (k)paramn;
      paramString = new HashSet();
      if (paramn.gUl != null)
      {
        localObject = paramn.gUl.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localbhm = (bhm)((Iterator)localObject).next();
            if ((localbhm == null) || (localbhm.DFs == null))
            {
              ad.i("MicroMsg.AvatarService", "error p is null or username is null %s", new Object[] { localbhm });
              continue;
              this.gTk = false;
            }
          }
        }
      }
    }
    catch (NullPointerException paramString)
    {
      ad.e("MicroMsg.AvatarService", "[onSceneEnd] NullPointerException:%s", new Object[] { paramString });
    }
    for (;;)
    {
      if (this.gTn.size() > 0) {
        this.gTs.av(0L, 0L);
      }
      AppMethodBeat.o(150233);
      return;
      String str = localbhm.DFs.Ehn;
      if ((localbhm.CxB == null) || (localbhm.CxB.getBuffer() == null) || (localbhm.CxB.getBuffer().wA == null))
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(138L, 11L, 1L, true);
        break;
      }
      paramString.add(str);
      i locali = new i();
      locali.username = str;
      locali.evo = 3;
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(138L, 43L, 1L, true);
      a(new e(locali, localbhm.CxB.getBuffer().wA));
      break;
      if (paramn.gUk != null)
      {
        paramn = paramn.gUk.iterator();
        while (paramn.hasNext())
        {
          localObject = (cmf)paramn.next();
          if (localObject != null)
          {
            localObject = ((cmf)localObject).Ehn;
            if (!paramString.contains(localObject)) {
              this.gTl.remove(localObject);
            }
          }
        }
      }
    }
  }
  
  public final void vP(String paramString)
  {
    AppMethodBeat.i(150228);
    a(new c(paramString));
    AppMethodBeat.o(150228);
  }
  
  public final void vQ(final String paramString)
  {
    AppMethodBeat.i(150229);
    com.tencent.e.h.Iye.aP(new com.tencent.e.i.j()
    {
      public final boolean adf()
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
        if (bt.isNullOrNil(paramString))
        {
          AppMethodBeat.o(150214);
          return;
        }
        if (paramString.equals(d.this.gTq))
        {
          AppMethodBeat.o(150214);
          return;
        }
        Object localObject = d.aur();
        if (localObject == null)
        {
          AppMethodBeat.o(150214);
          return;
        }
        localObject = ((j)localObject).we(paramString);
        if ((localObject == null) || (!((i)localObject).getUsername().equals(paramString)))
        {
          AppMethodBeat.o(150214);
          return;
        }
        if (bt.aGK() - ((i)localObject).gUi * 60L > 86400L) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(150214);
          return;
        }
        if (bt.isNullOrNil(((i)localObject).auy()))
        {
          ad.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", new Object[] { paramString });
          AppMethodBeat.o(150214);
          return;
        }
        if (d.auq() == null)
        {
          AppMethodBeat.o(150214);
          return;
        }
        e.K(paramString, false);
        e.K(paramString, true);
        d.this.vP(paramString);
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
  
  public final String vS(String paramString)
  {
    AppMethodBeat.i(150235);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150235);
      return "";
    }
    try
    {
      String str1 = String.format("%s%x_%s", new Object[] { "ammURL_", Integer.valueOf(paramString.hashCode()), paramString.substring(paramString.length() - 24, paramString.length() - 4) });
      this.gTr.put(str1, paramString);
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
  
  final class a
    implements be.a
  {
    boolean bym;
    i gTw;
    byte[] gTx;
    byte[] gTy;
    
    public a(i parami, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      this.gTw = parami;
      this.gTx = paramArrayOfByte;
      this.bym = paramBoolean;
    }
    
    public final boolean aus()
    {
      AppMethodBeat.i(150218);
      byte[] arrayOfByte;
      if (this.bym)
      {
        ad.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt");
        com.tencent.mm.plugin.report.service.h.vKh.dB(138, 51);
        arrayOfByte = UtilsJni.DecryptAvatar(this.gTx);
        if (bt.cw(arrayOfByte))
        {
          com.tencent.mm.plugin.report.service.h.vKh.dB(138, 52);
          ad.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt output empty");
          AppMethodBeat.o(150218);
          return false;
        }
      }
      else
      {
        arrayOfByte = this.gTx;
      }
      for (;;)
      {
        if (t.cp(arrayOfByte))
        {
          ad.i("MicroMsg.AvatarService", "DecryptAvatar: hevc to pic");
          com.tencent.mm.plugin.report.service.h.vKh.dB(138, 53);
          this.gTy = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).aV(arrayOfByte);
          if (bt.cw(this.gTy))
          {
            com.tencent.mm.plugin.report.service.h.vKh.dB(138, 54);
            ad.i("MicroMsg.AvatarService", "DecryptAvatar: output is empty");
            AppMethodBeat.o(150218);
            return false;
          }
        }
        else
        {
          this.gTy = arrayOfByte;
        }
        AppMethodBeat.o(150218);
        return true;
      }
    }
    
    public final boolean aut()
    {
      AppMethodBeat.i(150219);
      if (!bt.cw(this.gTy))
      {
        ad.i("MicroMsg.AvatarService", "DecryptAvatar: post to save length is %s", new Object[] { Integer.valueOf(this.gTy.length) });
        d.this.a(new d.e(d.this, this.gTw, this.gTy));
        AppMethodBeat.o(150219);
        return true;
      }
      ad.i("MicroMsg.AvatarService", "DecryptAvatar: onPostExecute output is empty");
      AppMethodBeat.o(150219);
      return false;
    }
  }
  
  final class b
    implements be.a
  {
    public boolean bym = false;
    public byte[] gTA = null;
    public i gTz = null;
    
    public b(i parami)
    {
      this.gTz = parami;
    }
    
    /* Error */
    public final boolean aus()
    {
      // Byte code:
      //   0: ldc 42
      //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 26	com/tencent/mm/ak/d$b:gTz	Lcom/tencent/mm/ak/i;
      //   9: ifnonnull +10 -> 19
      //   12: ldc 42
      //   14: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   17: iconst_0
      //   18: ireturn
      //   19: invokestatic 57	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   22: invokestatic 63	com/tencent/mm/sdk/platformtools/ay:isNetworkConnected	(Landroid/content/Context;)Z
      //   25: ifne +13 -> 38
      //   28: ldc 65
      //   30: ldc 67
      //   32: invokestatic 73	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   35: invokestatic 76	com/tencent/mm/sdk/platformtools/ad:eFw	()V
      //   38: aload_0
      //   39: getfield 26	com/tencent/mm/ak/d$b:gTz	Lcom/tencent/mm/ak/i;
      //   42: invokevirtual 82	com/tencent/mm/ak/i:auy	()Ljava/lang/String;
      //   45: astore 27
      //   47: ldc 84
      //   49: invokestatic 90	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   52: checkcast 84	com/tencent/mm/plugin/emoji/b/c
      //   55: invokeinterface 93 1 0
      //   60: istore_3
      //   61: ldc 95
      //   63: invokestatic 90	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   66: checkcast 95	com/tencent/mm/plugin/expt/a/b
      //   69: getstatic 101	com/tencent/mm/plugin/expt/a/b$a:ppO	Lcom/tencent/mm/plugin/expt/a/b$a;
      //   72: iconst_0
      //   73: invokeinterface 105 3 0
      //   78: istore 4
      //   80: iload_3
      //   81: ifeq +3716 -> 3797
      //   84: iload 4
      //   86: ifeq +3711 -> 3797
      //   89: ldc 65
      //   91: ldc 107
      //   93: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   96: aload 27
      //   98: ldc 111
      //   100: invokevirtual 117	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   103: ifeq +798 -> 901
      //   106: new 119	java/lang/StringBuilder
      //   109: dup
      //   110: invokespecial 120	java/lang/StringBuilder:<init>	()V
      //   113: aload 27
      //   115: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   118: ldc 126
      //   120: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   123: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   126: astore 15
      //   128: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   131: sipush 138
      //   134: bipush 50
      //   136: invokevirtual 139	com/tencent/mm/plugin/report/service/h:dB	(II)V
      //   139: aload 15
      //   141: astore 27
      //   143: invokestatic 143	com/tencent/mm/kernel/g:afz	()Lcom/tencent/mm/kernel/a;
      //   146: invokevirtual 148	com/tencent/mm/kernel/a:aeI	()Z
      //   149: ifeq +3640 -> 3789
      //   152: getstatic 154	com/tencent/mm/protocal/d:CpK	I
      //   155: istore_1
      //   156: invokestatic 143	com/tencent/mm/kernel/g:afz	()Lcom/tencent/mm/kernel/a;
      //   159: pop
      //   160: ldc 156
      //   162: iconst_4
      //   163: anewarray 4	java/lang/Object
      //   166: dup
      //   167: iconst_0
      //   168: iload_1
      //   169: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   172: aastore
      //   173: dup
      //   174: iconst_1
      //   175: invokestatic 166	com/tencent/mm/kernel/a:getUin	()I
      //   178: invokestatic 172	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
      //   181: aastore
      //   182: dup
      //   183: iconst_2
      //   184: invokestatic 57	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   187: invokestatic 176	com/tencent/mm/sdk/platformtools/ay:getNetTypeForStat	(Landroid/content/Context;)I
      //   190: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   193: aastore
      //   194: dup
      //   195: iconst_3
      //   196: invokestatic 57	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   199: invokestatic 179	com/tencent/mm/sdk/platformtools/ay:getStrength	(Landroid/content/Context;)I
      //   202: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   205: aastore
      //   206: invokestatic 183	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   209: astore 17
      //   211: ldc 65
      //   213: ldc 185
      //   215: iconst_2
      //   216: anewarray 4	java/lang/Object
      //   219: dup
      //   220: iconst_0
      //   221: aload_0
      //   222: getfield 26	com/tencent/mm/ak/d$b:gTz	Lcom/tencent/mm/ak/i;
      //   225: invokevirtual 188	com/tencent/mm/ak/i:getUsername	()Ljava/lang/String;
      //   228: aastore
      //   229: dup
      //   230: iconst_1
      //   231: aload 17
      //   233: aastore
      //   234: invokestatic 192	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   237: aload_0
      //   238: aconst_null
      //   239: putfield 28	com/tencent/mm/ak/d$b:gTA	[B
      //   242: aconst_null
      //   243: astore 15
      //   245: aconst_null
      //   246: astore 19
      //   248: aconst_null
      //   249: astore 20
      //   251: aconst_null
      //   252: astore 29
      //   254: aconst_null
      //   255: astore 21
      //   257: aconst_null
      //   258: astore 28
      //   260: aconst_null
      //   261: astore 26
      //   263: aconst_null
      //   264: astore 18
      //   266: new 194	java/io/ByteArrayOutputStream
      //   269: dup
      //   270: invokespecial 195	java/io/ByteArrayOutputStream:<init>	()V
      //   273: astore 16
      //   275: aconst_null
      //   276: astore 23
      //   278: aconst_null
      //   279: astore 24
      //   281: aconst_null
      //   282: astore 25
      //   284: aconst_null
      //   285: astore 22
      //   287: lconst_0
      //   288: lstore 5
      //   290: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   293: ldc2_w 196
      //   296: ldc2_w 198
      //   299: lconst_1
      //   300: iconst_1
      //   301: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   304: lload 5
      //   306: lstore 7
      //   308: lload 5
      //   310: lstore 9
      //   312: lload 5
      //   314: lstore 11
      //   316: lload 5
      //   318: lstore 13
      //   320: invokestatic 209	java/lang/System:currentTimeMillis	()J
      //   323: lstore 5
      //   325: lload 5
      //   327: lstore 7
      //   329: lload 5
      //   331: lstore 9
      //   333: lload 5
      //   335: lstore 11
      //   337: lload 5
      //   339: lstore 13
      //   341: ldc 95
      //   343: invokestatic 90	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   346: checkcast 95	com/tencent/mm/plugin/expt/a/b
      //   349: getstatic 212	com/tencent/mm/plugin/expt/a/b$a:pvR	Lcom/tencent/mm/plugin/expt/a/b$a;
      //   352: iconst_0
      //   353: invokeinterface 105 3 0
      //   358: istore_3
      //   359: iload_3
      //   360: ifeq +567 -> 927
      //   363: aload 29
      //   365: astore 20
      //   367: aload 28
      //   369: astore 21
      //   371: aload 27
      //   373: invokestatic 218	com/tencent/mm/network/b:AY	(Ljava/lang/String;)Lcom/tencent/mm/network/x;
      //   376: astore 15
      //   378: aload 15
      //   380: checkcast 220	com/tencent/mm/network/x
      //   383: sipush 1224
      //   386: putfield 223	com/tencent/mm/network/x:hMg	I
      //   389: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   392: ldc2_w 224
      //   395: ldc2_w 226
      //   398: lconst_1
      //   399: iconst_0
      //   400: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   403: aload 15
      //   405: astore 18
      //   407: aload 15
      //   409: astore 19
      //   411: aload 15
      //   413: astore 20
      //   415: aload 15
      //   417: astore 21
      //   419: aload 15
      //   421: ldc 229
      //   423: invokeinterface 235 2 0
      //   428: aload 15
      //   430: astore 18
      //   432: aload 15
      //   434: astore 19
      //   436: aload 15
      //   438: astore 20
      //   440: aload 15
      //   442: astore 21
      //   444: aload 15
      //   446: ldc 237
      //   448: aload 17
      //   450: invokeinterface 240 3 0
      //   455: aload 15
      //   457: astore 18
      //   459: aload 15
      //   461: astore 19
      //   463: aload 15
      //   465: astore 20
      //   467: aload 15
      //   469: astore 21
      //   471: aload 15
      //   473: sipush 5000
      //   476: invokeinterface 243 2 0
      //   481: aload 15
      //   483: astore 18
      //   485: aload 15
      //   487: astore 19
      //   489: aload 15
      //   491: astore 20
      //   493: aload 15
      //   495: astore 21
      //   497: aload 15
      //   499: sipush 5000
      //   502: invokeinterface 246 2 0
      //   507: aload 15
      //   509: astore 18
      //   511: aload 15
      //   513: astore 19
      //   515: aload 15
      //   517: astore 20
      //   519: aload 15
      //   521: astore 21
      //   523: aload 15
      //   525: invokeinterface 249 1 0
      //   530: istore_1
      //   531: iload_1
      //   532: sipush 200
      //   535: if_icmpeq +1936 -> 2471
      //   538: aload 15
      //   540: astore 18
      //   542: aload 15
      //   544: astore 19
      //   546: aload 15
      //   548: astore 20
      //   550: aload 15
      //   552: astore 21
      //   554: aload 15
      //   556: invokeinterface 253 1 0
      //   561: astore 17
      //   563: aload 17
      //   565: ifnull +395 -> 960
      //   568: aload 15
      //   570: astore 18
      //   572: aload 15
      //   574: astore 19
      //   576: aload 15
      //   578: astore 20
      //   580: aload 15
      //   582: astore 21
      //   584: aload 17
      //   586: ldc 255
      //   588: invokeinterface 261 2 0
      //   593: checkcast 263	java/util/List
      //   596: astore 17
      //   598: aload 17
      //   600: ifnull +366 -> 966
      //   603: aload 15
      //   605: astore 18
      //   607: aload 15
      //   609: astore 19
      //   611: aload 15
      //   613: astore 20
      //   615: aload 15
      //   617: astore 21
      //   619: aload 17
      //   621: invokeinterface 266 1 0
      //   626: ifle +340 -> 966
      //   629: aload 15
      //   631: astore 18
      //   633: aload 15
      //   635: astore 19
      //   637: aload 15
      //   639: astore 20
      //   641: aload 15
      //   643: astore 21
      //   645: aload 17
      //   647: iconst_0
      //   648: invokeinterface 269 2 0
      //   653: checkcast 113	java/lang/String
      //   656: astore 17
      //   658: aload 15
      //   660: astore 18
      //   662: aload 15
      //   664: astore 19
      //   666: aload 15
      //   668: astore 20
      //   670: aload 15
      //   672: astore 21
      //   674: ldc 65
      //   676: ldc_w 271
      //   679: iconst_3
      //   680: anewarray 4	java/lang/Object
      //   683: dup
      //   684: iconst_0
      //   685: aload 27
      //   687: aastore
      //   688: dup
      //   689: iconst_1
      //   690: iload_1
      //   691: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   694: aastore
      //   695: dup
      //   696: iconst_2
      //   697: aload 17
      //   699: aastore
      //   700: invokestatic 274	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   703: iload_1
      //   704: lookupswitch	default:+3096->3800, 404:+270->974, 502:+710->1414, 503:+1063->1767, 504:+1416->2120
      //   749: dconst_1
      //   750: astore 18
      //   752: aload 15
      //   754: astore 19
      //   756: aload 15
      //   758: astore 20
      //   760: aload 15
      //   762: astore 21
      //   764: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   767: ldc2_w 196
      //   770: ldc2_w 275
      //   773: lconst_1
      //   774: iconst_1
      //   775: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   778: aload 15
      //   780: astore 18
      //   782: aload 15
      //   784: astore 19
      //   786: aload 15
      //   788: astore 20
      //   790: aload 15
      //   792: astore 21
      //   794: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   797: sipush 14058
      //   800: bipush 10
      //   802: anewarray 4	java/lang/Object
      //   805: dup
      //   806: iconst_0
      //   807: ldc_w 277
      //   810: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   813: aastore
      //   814: dup
      //   815: iconst_1
      //   816: iload_1
      //   817: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   820: aastore
      //   821: dup
      //   822: iconst_2
      //   823: ldc_w 279
      //   826: aastore
      //   827: dup
      //   828: iconst_3
      //   829: iconst_0
      //   830: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   833: aastore
      //   834: dup
      //   835: iconst_4
      //   836: aload_0
      //   837: getfield 26	com/tencent/mm/ak/d$b:gTz	Lcom/tencent/mm/ak/i;
      //   840: invokevirtual 188	com/tencent/mm/ak/i:getUsername	()Ljava/lang/String;
      //   843: aastore
      //   844: dup
      //   845: iconst_5
      //   846: aload 15
      //   848: invokeinterface 282 1 0
      //   853: aastore
      //   854: dup
      //   855: bipush 6
      //   857: aload 15
      //   859: invokeinterface 285 1 0
      //   864: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   867: aastore
      //   868: dup
      //   869: bipush 7
      //   871: aload 15
      //   873: invokeinterface 288 1 0
      //   878: aastore
      //   879: dup
      //   880: bipush 8
      //   882: aload 27
      //   884: aastore
      //   885: dup
      //   886: bipush 9
      //   888: aload 17
      //   890: aastore
      //   891: invokevirtual 292	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
      //   894: ldc 42
      //   896: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   899: iconst_1
      //   900: ireturn
      //   901: new 119	java/lang/StringBuilder
      //   904: dup
      //   905: invokespecial 120	java/lang/StringBuilder:<init>	()V
      //   908: aload 27
      //   910: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   913: ldc_w 294
      //   916: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   919: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   922: astore 15
      //   924: goto -796 -> 128
      //   927: aload 29
      //   929: astore 20
      //   931: aload 28
      //   933: astore 21
      //   935: aload 27
      //   937: aconst_null
      //   938: invokestatic 297	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
      //   941: astore 15
      //   943: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   946: ldc2_w 224
      //   949: ldc2_w 298
      //   952: lconst_1
      //   953: iconst_0
      //   954: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   957: goto -554 -> 403
      //   960: aconst_null
      //   961: astore 17
      //   963: goto -365 -> 598
      //   966: ldc_w 279
      //   969: astore 17
      //   971: goto -313 -> 658
      //   974: aload 15
      //   976: astore 18
      //   978: aload 15
      //   980: astore 19
      //   982: aload 15
      //   984: astore 20
      //   986: aload 15
      //   988: astore 21
      //   990: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   993: ldc2_w 196
      //   996: ldc2_w 300
      //   999: lconst_1
      //   1000: iconst_1
      //   1001: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1004: aload 15
      //   1006: astore 18
      //   1008: aload 15
      //   1010: astore 19
      //   1012: aload 15
      //   1014: astore 20
      //   1016: aload 15
      //   1018: astore 21
      //   1020: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   1023: sipush 14058
      //   1026: bipush 10
      //   1028: anewarray 4	java/lang/Object
      //   1031: dup
      //   1032: iconst_0
      //   1033: ldc_w 277
      //   1036: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1039: aastore
      //   1040: dup
      //   1041: iconst_1
      //   1042: iload_1
      //   1043: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1046: aastore
      //   1047: dup
      //   1048: iconst_2
      //   1049: ldc_w 279
      //   1052: aastore
      //   1053: dup
      //   1054: iconst_3
      //   1055: iconst_0
      //   1056: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1059: aastore
      //   1060: dup
      //   1061: iconst_4
      //   1062: aload_0
      //   1063: getfield 26	com/tencent/mm/ak/d$b:gTz	Lcom/tencent/mm/ak/i;
      //   1066: invokevirtual 188	com/tencent/mm/ak/i:getUsername	()Ljava/lang/String;
      //   1069: aastore
      //   1070: dup
      //   1071: iconst_5
      //   1072: aload 15
      //   1074: invokeinterface 282 1 0
      //   1079: aastore
      //   1080: dup
      //   1081: bipush 6
      //   1083: aload 15
      //   1085: invokeinterface 285 1 0
      //   1090: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1093: aastore
      //   1094: dup
      //   1095: bipush 7
      //   1097: aload 15
      //   1099: invokeinterface 288 1 0
      //   1104: aastore
      //   1105: dup
      //   1106: bipush 8
      //   1108: aload 27
      //   1110: aastore
      //   1111: dup
      //   1112: bipush 9
      //   1114: aload 17
      //   1116: aastore
      //   1117: invokevirtual 292	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
      //   1120: goto -226 -> 894
      //   1123: astore 17
      //   1125: aload 18
      //   1127: astore 15
      //   1129: aload 22
      //   1131: astore 18
      //   1133: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   1136: ldc2_w 196
      //   1139: lconst_1
      //   1140: lconst_1
      //   1141: iconst_1
      //   1142: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1145: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   1148: astore 22
      //   1150: aload 17
      //   1152: invokevirtual 304	java/net/ProtocolException:getMessage	()Ljava/lang/String;
      //   1155: astore 23
      //   1157: aload_0
      //   1158: getfield 26	com/tencent/mm/ak/d$b:gTz	Lcom/tencent/mm/ak/i;
      //   1161: invokevirtual 188	com/tencent/mm/ak/i:getUsername	()Ljava/lang/String;
      //   1164: astore 24
      //   1166: aload 15
      //   1168: ifnonnull +2063 -> 3231
      //   1171: ldc_w 306
      //   1174: astore 19
      //   1176: aload 15
      //   1178: ifnonnull +2065 -> 3243
      //   1181: ldc_w 306
      //   1184: astore 20
      //   1186: aload 15
      //   1188: ifnonnull +2070 -> 3258
      //   1191: ldc_w 306
      //   1194: astore 21
      //   1196: aload 22
      //   1198: sipush 14058
      //   1201: bipush 10
      //   1203: anewarray 4	java/lang/Object
      //   1206: dup
      //   1207: iconst_0
      //   1208: ldc_w 277
      //   1211: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1214: aastore
      //   1215: dup
      //   1216: iconst_1
      //   1217: sipush 10001
      //   1220: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1223: aastore
      //   1224: dup
      //   1225: iconst_2
      //   1226: aload 23
      //   1228: aastore
      //   1229: dup
      //   1230: iconst_3
      //   1231: iconst_0
      //   1232: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1235: aastore
      //   1236: dup
      //   1237: iconst_4
      //   1238: aload 24
      //   1240: aastore
      //   1241: dup
      //   1242: iconst_5
      //   1243: aload 19
      //   1245: aastore
      //   1246: dup
      //   1247: bipush 6
      //   1249: aload 20
      //   1251: aastore
      //   1252: dup
      //   1253: bipush 7
      //   1255: aload 21
      //   1257: aastore
      //   1258: dup
      //   1259: bipush 8
      //   1261: aload 27
      //   1263: aastore
      //   1264: dup
      //   1265: bipush 9
      //   1267: ldc_w 279
      //   1270: aastore
      //   1271: invokevirtual 292	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
      //   1274: ldc 65
      //   1276: ldc_w 308
      //   1279: iconst_3
      //   1280: anewarray 4	java/lang/Object
      //   1283: dup
      //   1284: iconst_0
      //   1285: aload 27
      //   1287: aastore
      //   1288: dup
      //   1289: iconst_1
      //   1290: aload 17
      //   1292: invokevirtual 312	java/lang/Object:getClass	()Ljava/lang/Class;
      //   1295: invokevirtual 317	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   1298: aastore
      //   1299: dup
      //   1300: iconst_2
      //   1301: aload 17
      //   1303: invokevirtual 304	java/net/ProtocolException:getMessage	()Ljava/lang/String;
      //   1306: aastore
      //   1307: invokestatic 274	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1310: aload 16
      //   1312: astore 17
      //   1314: aload 18
      //   1316: astore 16
      //   1318: aload 15
      //   1320: ifnull +10 -> 1330
      //   1323: aload 15
      //   1325: invokeinterface 320 1 0
      //   1330: aload 16
      //   1332: ifnull +8 -> 1340
      //   1335: aload 16
      //   1337: invokevirtual 325	java/io/InputStream:close	()V
      //   1340: aload 17
      //   1342: ifnull +8 -> 1350
      //   1345: aload 17
      //   1347: invokevirtual 326	java/io/ByteArrayOutputStream:close	()V
      //   1350: invokestatic 209	java/lang/System:currentTimeMillis	()J
      //   1353: lload 5
      //   1355: lsub
      //   1356: lstore 5
      //   1358: iload_3
      //   1359: ifeq +2028 -> 3387
      //   1362: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   1365: ldc2_w 224
      //   1368: ldc2_w 327
      //   1371: lload 5
      //   1373: iconst_0
      //   1374: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1377: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   1380: ldc2_w 224
      //   1383: ldc2_w 329
      //   1386: lconst_1
      //   1387: iconst_0
      //   1388: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1391: ldc 65
      //   1393: ldc_w 332
      //   1396: lload 5
      //   1398: invokestatic 335	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   1401: invokevirtual 339	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   1404: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1407: ldc 42
      //   1409: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1412: iconst_1
      //   1413: ireturn
      //   1414: aload 15
      //   1416: astore 18
      //   1418: aload 15
      //   1420: astore 19
      //   1422: aload 15
      //   1424: astore 20
      //   1426: aload 15
      //   1428: astore 21
      //   1430: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   1433: ldc2_w 196
      //   1436: ldc2_w 340
      //   1439: lconst_1
      //   1440: iconst_1
      //   1441: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1444: aload 15
      //   1446: astore 18
      //   1448: aload 15
      //   1450: astore 19
      //   1452: aload 15
      //   1454: astore 20
      //   1456: aload 15
      //   1458: astore 21
      //   1460: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   1463: sipush 14058
      //   1466: bipush 10
      //   1468: anewarray 4	java/lang/Object
      //   1471: dup
      //   1472: iconst_0
      //   1473: ldc_w 277
      //   1476: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1479: aastore
      //   1480: dup
      //   1481: iconst_1
      //   1482: iload_1
      //   1483: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1486: aastore
      //   1487: dup
      //   1488: iconst_2
      //   1489: ldc_w 279
      //   1492: aastore
      //   1493: dup
      //   1494: iconst_3
      //   1495: iconst_0
      //   1496: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1499: aastore
      //   1500: dup
      //   1501: iconst_4
      //   1502: aload_0
      //   1503: getfield 26	com/tencent/mm/ak/d$b:gTz	Lcom/tencent/mm/ak/i;
      //   1506: invokevirtual 188	com/tencent/mm/ak/i:getUsername	()Ljava/lang/String;
      //   1509: aastore
      //   1510: dup
      //   1511: iconst_5
      //   1512: aload 15
      //   1514: invokeinterface 282 1 0
      //   1519: aastore
      //   1520: dup
      //   1521: bipush 6
      //   1523: aload 15
      //   1525: invokeinterface 285 1 0
      //   1530: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1533: aastore
      //   1534: dup
      //   1535: bipush 7
      //   1537: aload 15
      //   1539: invokeinterface 288 1 0
      //   1544: aastore
      //   1545: dup
      //   1546: bipush 8
      //   1548: aload 27
      //   1550: aastore
      //   1551: dup
      //   1552: bipush 9
      //   1554: aload 17
      //   1556: aastore
      //   1557: invokevirtual 292	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
      //   1560: goto -666 -> 894
      //   1563: astore 17
      //   1565: aload 19
      //   1567: astore 15
      //   1569: aload 16
      //   1571: astore 19
      //   1573: aload 23
      //   1575: astore 18
      //   1577: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   1580: ldc2_w 196
      //   1583: ldc2_w 342
      //   1586: lconst_1
      //   1587: iconst_1
      //   1588: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1591: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   1594: astore 22
      //   1596: aload 17
      //   1598: invokevirtual 344	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
      //   1601: astore 23
      //   1603: aload_0
      //   1604: getfield 26	com/tencent/mm/ak/d$b:gTz	Lcom/tencent/mm/ak/i;
      //   1607: invokevirtual 188	com/tencent/mm/ak/i:getUsername	()Ljava/lang/String;
      //   1610: astore 24
      //   1612: aload 15
      //   1614: ifnonnull +1656 -> 3270
      //   1617: ldc_w 306
      //   1620: astore 16
      //   1622: aload 15
      //   1624: ifnonnull +1658 -> 3282
      //   1627: ldc_w 306
      //   1630: astore 20
      //   1632: aload 15
      //   1634: ifnonnull +1663 -> 3297
      //   1637: ldc_w 306
      //   1640: astore 21
      //   1642: aload 22
      //   1644: sipush 14058
      //   1647: bipush 10
      //   1649: anewarray 4	java/lang/Object
      //   1652: dup
      //   1653: iconst_0
      //   1654: ldc_w 277
      //   1657: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1660: aastore
      //   1661: dup
      //   1662: iconst_1
      //   1663: sipush 10002
      //   1666: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1669: aastore
      //   1670: dup
      //   1671: iconst_2
      //   1672: aload 23
      //   1674: aastore
      //   1675: dup
      //   1676: iconst_3
      //   1677: iconst_0
      //   1678: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1681: aastore
      //   1682: dup
      //   1683: iconst_4
      //   1684: aload 24
      //   1686: aastore
      //   1687: dup
      //   1688: iconst_5
      //   1689: aload 16
      //   1691: aastore
      //   1692: dup
      //   1693: bipush 6
      //   1695: aload 20
      //   1697: aastore
      //   1698: dup
      //   1699: bipush 7
      //   1701: aload 21
      //   1703: aastore
      //   1704: dup
      //   1705: bipush 8
      //   1707: aload 27
      //   1709: aastore
      //   1710: dup
      //   1711: bipush 9
      //   1713: ldc_w 279
      //   1716: aastore
      //   1717: invokevirtual 292	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
      //   1720: ldc 65
      //   1722: ldc_w 308
      //   1725: iconst_3
      //   1726: anewarray 4	java/lang/Object
      //   1729: dup
      //   1730: iconst_0
      //   1731: aload 27
      //   1733: aastore
      //   1734: dup
      //   1735: iconst_1
      //   1736: aload 17
      //   1738: invokevirtual 312	java/lang/Object:getClass	()Ljava/lang/Class;
      //   1741: invokevirtual 317	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   1744: aastore
      //   1745: dup
      //   1746: iconst_2
      //   1747: aload 17
      //   1749: invokevirtual 344	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
      //   1752: aastore
      //   1753: invokestatic 274	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1756: aload 18
      //   1758: astore 16
      //   1760: aload 19
      //   1762: astore 17
      //   1764: goto -446 -> 1318
      //   1767: aload 15
      //   1769: astore 18
      //   1771: aload 15
      //   1773: astore 19
      //   1775: aload 15
      //   1777: astore 20
      //   1779: aload 15
      //   1781: astore 21
      //   1783: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   1786: ldc2_w 196
      //   1789: ldc2_w 345
      //   1792: lconst_1
      //   1793: iconst_1
      //   1794: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1797: aload 15
      //   1799: astore 18
      //   1801: aload 15
      //   1803: astore 19
      //   1805: aload 15
      //   1807: astore 20
      //   1809: aload 15
      //   1811: astore 21
      //   1813: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   1816: sipush 14058
      //   1819: bipush 10
      //   1821: anewarray 4	java/lang/Object
      //   1824: dup
      //   1825: iconst_0
      //   1826: ldc_w 277
      //   1829: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1832: aastore
      //   1833: dup
      //   1834: iconst_1
      //   1835: iload_1
      //   1836: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1839: aastore
      //   1840: dup
      //   1841: iconst_2
      //   1842: ldc_w 279
      //   1845: aastore
      //   1846: dup
      //   1847: iconst_3
      //   1848: iconst_0
      //   1849: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1852: aastore
      //   1853: dup
      //   1854: iconst_4
      //   1855: aload_0
      //   1856: getfield 26	com/tencent/mm/ak/d$b:gTz	Lcom/tencent/mm/ak/i;
      //   1859: invokevirtual 188	com/tencent/mm/ak/i:getUsername	()Ljava/lang/String;
      //   1862: aastore
      //   1863: dup
      //   1864: iconst_5
      //   1865: aload 15
      //   1867: invokeinterface 282 1 0
      //   1872: aastore
      //   1873: dup
      //   1874: bipush 6
      //   1876: aload 15
      //   1878: invokeinterface 285 1 0
      //   1883: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1886: aastore
      //   1887: dup
      //   1888: bipush 7
      //   1890: aload 15
      //   1892: invokeinterface 288 1 0
      //   1897: aastore
      //   1898: dup
      //   1899: bipush 8
      //   1901: aload 27
      //   1903: aastore
      //   1904: dup
      //   1905: bipush 9
      //   1907: aload 17
      //   1909: aastore
      //   1910: invokevirtual 292	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
      //   1913: goto -1019 -> 894
      //   1916: astore 17
      //   1918: aload 20
      //   1920: astore 15
      //   1922: aload 16
      //   1924: astore 19
      //   1926: aload 24
      //   1928: astore 18
      //   1930: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   1933: ldc2_w 196
      //   1936: ldc2_w 347
      //   1939: lconst_1
      //   1940: iconst_1
      //   1941: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1944: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   1947: astore 22
      //   1949: aload 17
      //   1951: invokevirtual 349	java/io/IOException:getMessage	()Ljava/lang/String;
      //   1954: astore 23
      //   1956: aload_0
      //   1957: getfield 26	com/tencent/mm/ak/d$b:gTz	Lcom/tencent/mm/ak/i;
      //   1960: invokevirtual 188	com/tencent/mm/ak/i:getUsername	()Ljava/lang/String;
      //   1963: astore 24
      //   1965: aload 15
      //   1967: ifnonnull +1342 -> 3309
      //   1970: ldc_w 306
      //   1973: astore 16
      //   1975: aload 15
      //   1977: ifnonnull +1344 -> 3321
      //   1980: ldc_w 306
      //   1983: astore 20
      //   1985: aload 15
      //   1987: ifnonnull +1349 -> 3336
      //   1990: ldc_w 306
      //   1993: astore 21
      //   1995: aload 22
      //   1997: sipush 14058
      //   2000: bipush 10
      //   2002: anewarray 4	java/lang/Object
      //   2005: dup
      //   2006: iconst_0
      //   2007: ldc_w 277
      //   2010: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2013: aastore
      //   2014: dup
      //   2015: iconst_1
      //   2016: sipush 10003
      //   2019: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2022: aastore
      //   2023: dup
      //   2024: iconst_2
      //   2025: aload 23
      //   2027: aastore
      //   2028: dup
      //   2029: iconst_3
      //   2030: iconst_0
      //   2031: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2034: aastore
      //   2035: dup
      //   2036: iconst_4
      //   2037: aload 24
      //   2039: aastore
      //   2040: dup
      //   2041: iconst_5
      //   2042: aload 16
      //   2044: aastore
      //   2045: dup
      //   2046: bipush 6
      //   2048: aload 20
      //   2050: aastore
      //   2051: dup
      //   2052: bipush 7
      //   2054: aload 21
      //   2056: aastore
      //   2057: dup
      //   2058: bipush 8
      //   2060: aload 27
      //   2062: aastore
      //   2063: dup
      //   2064: bipush 9
      //   2066: ldc_w 279
      //   2069: aastore
      //   2070: invokevirtual 292	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
      //   2073: ldc 65
      //   2075: ldc_w 308
      //   2078: iconst_3
      //   2079: anewarray 4	java/lang/Object
      //   2082: dup
      //   2083: iconst_0
      //   2084: aload 27
      //   2086: aastore
      //   2087: dup
      //   2088: iconst_1
      //   2089: aload 17
      //   2091: invokevirtual 312	java/lang/Object:getClass	()Ljava/lang/Class;
      //   2094: invokevirtual 317	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   2097: aastore
      //   2098: dup
      //   2099: iconst_2
      //   2100: aload 17
      //   2102: invokevirtual 349	java/io/IOException:getMessage	()Ljava/lang/String;
      //   2105: aastore
      //   2106: invokestatic 274	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2109: aload 18
      //   2111: astore 16
      //   2113: aload 19
      //   2115: astore 17
      //   2117: goto -799 -> 1318
      //   2120: aload 15
      //   2122: astore 18
      //   2124: aload 15
      //   2126: astore 19
      //   2128: aload 15
      //   2130: astore 20
      //   2132: aload 15
      //   2134: astore 21
      //   2136: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   2139: ldc2_w 196
      //   2142: ldc2_w 350
      //   2145: lconst_1
      //   2146: iconst_1
      //   2147: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   2150: aload 15
      //   2152: astore 18
      //   2154: aload 15
      //   2156: astore 19
      //   2158: aload 15
      //   2160: astore 20
      //   2162: aload 15
      //   2164: astore 21
      //   2166: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   2169: sipush 14058
      //   2172: bipush 10
      //   2174: anewarray 4	java/lang/Object
      //   2177: dup
      //   2178: iconst_0
      //   2179: ldc_w 277
      //   2182: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2185: aastore
      //   2186: dup
      //   2187: iconst_1
      //   2188: iload_1
      //   2189: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2192: aastore
      //   2193: dup
      //   2194: iconst_2
      //   2195: ldc_w 279
      //   2198: aastore
      //   2199: dup
      //   2200: iconst_3
      //   2201: iconst_0
      //   2202: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2205: aastore
      //   2206: dup
      //   2207: iconst_4
      //   2208: aload_0
      //   2209: getfield 26	com/tencent/mm/ak/d$b:gTz	Lcom/tencent/mm/ak/i;
      //   2212: invokevirtual 188	com/tencent/mm/ak/i:getUsername	()Ljava/lang/String;
      //   2215: aastore
      //   2216: dup
      //   2217: iconst_5
      //   2218: aload 15
      //   2220: invokeinterface 282 1 0
      //   2225: aastore
      //   2226: dup
      //   2227: bipush 6
      //   2229: aload 15
      //   2231: invokeinterface 285 1 0
      //   2236: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2239: aastore
      //   2240: dup
      //   2241: bipush 7
      //   2243: aload 15
      //   2245: invokeinterface 288 1 0
      //   2250: aastore
      //   2251: dup
      //   2252: bipush 8
      //   2254: aload 27
      //   2256: aastore
      //   2257: dup
      //   2258: bipush 9
      //   2260: aload 17
      //   2262: aastore
      //   2263: invokevirtual 292	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
      //   2266: goto -1372 -> 894
      //   2269: astore 17
      //   2271: aload 21
      //   2273: astore 15
      //   2275: aload 16
      //   2277: astore 19
      //   2279: aload 25
      //   2281: astore 18
      //   2283: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   2286: ldc2_w 196
      //   2289: lconst_0
      //   2290: lconst_1
      //   2291: iconst_1
      //   2292: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   2295: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   2298: astore 22
      //   2300: aload 17
      //   2302: invokevirtual 352	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   2305: astore 23
      //   2307: aload_0
      //   2308: getfield 26	com/tencent/mm/ak/d$b:gTz	Lcom/tencent/mm/ak/i;
      //   2311: invokevirtual 188	com/tencent/mm/ak/i:getUsername	()Ljava/lang/String;
      //   2314: astore 24
      //   2316: aload 15
      //   2318: ifnonnull +1030 -> 3348
      //   2321: ldc_w 306
      //   2324: astore 16
      //   2326: aload 15
      //   2328: ifnonnull +1032 -> 3360
      //   2331: ldc_w 306
      //   2334: astore 20
      //   2336: aload 15
      //   2338: ifnonnull +1037 -> 3375
      //   2341: ldc_w 306
      //   2344: astore 21
      //   2346: aload 22
      //   2348: sipush 14058
      //   2351: bipush 10
      //   2353: anewarray 4	java/lang/Object
      //   2356: dup
      //   2357: iconst_0
      //   2358: ldc_w 277
      //   2361: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2364: aastore
      //   2365: dup
      //   2366: iconst_1
      //   2367: sipush 10003
      //   2370: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2373: aastore
      //   2374: dup
      //   2375: iconst_2
      //   2376: aload 23
      //   2378: aastore
      //   2379: dup
      //   2380: iconst_3
      //   2381: iconst_0
      //   2382: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2385: aastore
      //   2386: dup
      //   2387: iconst_4
      //   2388: aload 24
      //   2390: aastore
      //   2391: dup
      //   2392: iconst_5
      //   2393: aload 16
      //   2395: aastore
      //   2396: dup
      //   2397: bipush 6
      //   2399: aload 20
      //   2401: aastore
      //   2402: dup
      //   2403: bipush 7
      //   2405: aload 21
      //   2407: aastore
      //   2408: dup
      //   2409: bipush 8
      //   2411: aload 27
      //   2413: aastore
      //   2414: dup
      //   2415: bipush 9
      //   2417: ldc_w 279
      //   2420: aastore
      //   2421: invokevirtual 292	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
      //   2424: ldc 65
      //   2426: ldc_w 308
      //   2429: iconst_3
      //   2430: anewarray 4	java/lang/Object
      //   2433: dup
      //   2434: iconst_0
      //   2435: aload 27
      //   2437: aastore
      //   2438: dup
      //   2439: iconst_1
      //   2440: aload 17
      //   2442: invokevirtual 312	java/lang/Object:getClass	()Ljava/lang/Class;
      //   2445: invokevirtual 317	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   2448: aastore
      //   2449: dup
      //   2450: iconst_2
      //   2451: aload 17
      //   2453: invokevirtual 352	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   2456: aastore
      //   2457: invokestatic 274	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2460: aload 18
      //   2462: astore 16
      //   2464: aload 19
      //   2466: astore 17
      //   2468: goto -1150 -> 1318
      //   2471: aload 15
      //   2473: astore 18
      //   2475: aload 15
      //   2477: astore 19
      //   2479: aload 15
      //   2481: astore 20
      //   2483: aload 15
      //   2485: astore 21
      //   2487: aload 15
      //   2489: ldc_w 354
      //   2492: iconst_0
      //   2493: invokeinterface 358 3 0
      //   2498: iconst_1
      //   2499: if_icmpne +138 -> 2637
      //   2502: iconst_1
      //   2503: istore 4
      //   2505: aload 15
      //   2507: astore 18
      //   2509: aload 15
      //   2511: astore 19
      //   2513: aload 15
      //   2515: astore 20
      //   2517: aload 15
      //   2519: astore 21
      //   2521: aload_0
      //   2522: iload 4
      //   2524: putfield 30	com/tencent/mm/ak/d$b:bym	Z
      //   2527: aload 15
      //   2529: astore 18
      //   2531: aload 15
      //   2533: astore 19
      //   2535: aload 15
      //   2537: astore 20
      //   2539: aload 15
      //   2541: astore 21
      //   2543: aload 15
      //   2545: invokeinterface 361 1 0
      //   2550: istore_1
      //   2551: aload 15
      //   2553: astore 18
      //   2555: aload 15
      //   2557: astore 19
      //   2559: aload 15
      //   2561: astore 20
      //   2563: aload 15
      //   2565: astore 21
      //   2567: aload 15
      //   2569: invokeinterface 365 1 0
      //   2574: astore 17
      //   2576: aload 17
      //   2578: ifnonnull +65 -> 2643
      //   2581: aload 16
      //   2583: astore 19
      //   2585: aload 15
      //   2587: astore 20
      //   2589: aload 16
      //   2591: astore 21
      //   2593: aload 15
      //   2595: astore 22
      //   2597: aload 16
      //   2599: astore 23
      //   2601: aload 15
      //   2603: astore 24
      //   2605: aload 16
      //   2607: astore 25
      //   2609: aload 15
      //   2611: astore 26
      //   2613: ldc 65
      //   2615: ldc_w 367
      //   2618: iconst_1
      //   2619: anewarray 4	java/lang/Object
      //   2622: dup
      //   2623: iconst_0
      //   2624: aload 27
      //   2626: aastore
      //   2627: invokestatic 192	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2630: ldc 42
      //   2632: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2635: iconst_1
      //   2636: ireturn
      //   2637: iconst_0
      //   2638: istore 4
      //   2640: goto -135 -> 2505
      //   2643: aload 16
      //   2645: astore 19
      //   2647: aload 15
      //   2649: astore 20
      //   2651: aload 16
      //   2653: astore 21
      //   2655: aload 15
      //   2657: astore 22
      //   2659: aload 16
      //   2661: astore 23
      //   2663: aload 15
      //   2665: astore 24
      //   2667: aload 16
      //   2669: astore 25
      //   2671: aload 15
      //   2673: astore 26
      //   2675: sipush 1024
      //   2678: newarray byte
      //   2680: astore 18
      //   2682: aload 16
      //   2684: astore 19
      //   2686: aload 15
      //   2688: astore 20
      //   2690: aload 16
      //   2692: astore 21
      //   2694: aload 15
      //   2696: astore 22
      //   2698: aload 16
      //   2700: astore 23
      //   2702: aload 15
      //   2704: astore 24
      //   2706: aload 16
      //   2708: astore 25
      //   2710: aload 15
      //   2712: astore 26
      //   2714: aload 17
      //   2716: aload 18
      //   2718: invokevirtual 371	java/io/InputStream:read	([B)I
      //   2721: istore_2
      //   2722: iload_2
      //   2723: iconst_m1
      //   2724: if_icmpeq +47 -> 2771
      //   2727: aload 16
      //   2729: astore 19
      //   2731: aload 15
      //   2733: astore 20
      //   2735: aload 16
      //   2737: astore 21
      //   2739: aload 15
      //   2741: astore 22
      //   2743: aload 16
      //   2745: astore 23
      //   2747: aload 15
      //   2749: astore 24
      //   2751: aload 16
      //   2753: astore 25
      //   2755: aload 15
      //   2757: astore 26
      //   2759: aload 16
      //   2761: aload 18
      //   2763: iconst_0
      //   2764: iload_2
      //   2765: invokevirtual 375	java/io/ByteArrayOutputStream:write	([BII)V
      //   2768: goto -86 -> 2682
      //   2771: aload 16
      //   2773: astore 19
      //   2775: aload 15
      //   2777: astore 20
      //   2779: aload 16
      //   2781: astore 21
      //   2783: aload 15
      //   2785: astore 22
      //   2787: aload 16
      //   2789: astore 23
      //   2791: aload 15
      //   2793: astore 24
      //   2795: aload 16
      //   2797: astore 25
      //   2799: aload 15
      //   2801: astore 26
      //   2803: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   2806: ldc2_w 196
      //   2809: ldc2_w 376
      //   2812: lconst_1
      //   2813: iconst_1
      //   2814: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   2817: aload 16
      //   2819: astore 19
      //   2821: aload 15
      //   2823: astore 20
      //   2825: aload 16
      //   2827: astore 21
      //   2829: aload 15
      //   2831: astore 22
      //   2833: aload 16
      //   2835: astore 23
      //   2837: aload 15
      //   2839: astore 24
      //   2841: aload 16
      //   2843: astore 25
      //   2845: aload 15
      //   2847: astore 26
      //   2849: invokestatic 382	com/tencent/mm/sdk/a/b:eEQ	()Z
      //   2852: ifeq +138 -> 2990
      //   2855: aload 16
      //   2857: astore 19
      //   2859: aload 15
      //   2861: astore 20
      //   2863: aload 16
      //   2865: astore 21
      //   2867: aload 15
      //   2869: astore 22
      //   2871: aload 16
      //   2873: astore 23
      //   2875: aload 15
      //   2877: astore 24
      //   2879: aload 16
      //   2881: astore 25
      //   2883: aload 15
      //   2885: astore 26
      //   2887: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   2890: sipush 14058
      //   2893: bipush 10
      //   2895: anewarray 4	java/lang/Object
      //   2898: dup
      //   2899: iconst_0
      //   2900: ldc_w 277
      //   2903: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2906: aastore
      //   2907: dup
      //   2908: iconst_1
      //   2909: sipush 20000
      //   2912: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2915: aastore
      //   2916: dup
      //   2917: iconst_2
      //   2918: ldc_w 279
      //   2921: aastore
      //   2922: dup
      //   2923: iconst_3
      //   2924: iload_1
      //   2925: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2928: aastore
      //   2929: dup
      //   2930: iconst_4
      //   2931: aload_0
      //   2932: getfield 26	com/tencent/mm/ak/d$b:gTz	Lcom/tencent/mm/ak/i;
      //   2935: invokevirtual 188	com/tencent/mm/ak/i:getUsername	()Ljava/lang/String;
      //   2938: aastore
      //   2939: dup
      //   2940: iconst_5
      //   2941: aload 15
      //   2943: invokeinterface 282 1 0
      //   2948: aastore
      //   2949: dup
      //   2950: bipush 6
      //   2952: aload 15
      //   2954: invokeinterface 285 1 0
      //   2959: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2962: aastore
      //   2963: dup
      //   2964: bipush 7
      //   2966: aload 15
      //   2968: invokeinterface 288 1 0
      //   2973: aastore
      //   2974: dup
      //   2975: bipush 8
      //   2977: aload 27
      //   2979: aastore
      //   2980: dup
      //   2981: bipush 9
      //   2983: ldc_w 279
      //   2986: aastore
      //   2987: invokevirtual 292	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
      //   2990: aload 16
      //   2992: astore 19
      //   2994: aload 15
      //   2996: astore 20
      //   2998: aload 16
      //   3000: astore 21
      //   3002: aload 15
      //   3004: astore 22
      //   3006: aload 16
      //   3008: astore 23
      //   3010: aload 15
      //   3012: astore 24
      //   3014: aload 16
      //   3016: astore 25
      //   3018: aload 15
      //   3020: astore 26
      //   3022: aload_0
      //   3023: aload 16
      //   3025: invokevirtual 386	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   3028: putfield 28	com/tencent/mm/ak/d$b:gTA	[B
      //   3031: aload 16
      //   3033: astore 19
      //   3035: aload 15
      //   3037: astore 20
      //   3039: aload 16
      //   3041: astore 21
      //   3043: aload 15
      //   3045: astore 22
      //   3047: aload 16
      //   3049: astore 23
      //   3051: aload 15
      //   3053: astore 24
      //   3055: aload 16
      //   3057: astore 25
      //   3059: aload 15
      //   3061: astore 26
      //   3063: aload 16
      //   3065: invokevirtual 326	java/io/ByteArrayOutputStream:close	()V
      //   3068: aconst_null
      //   3069: astore 18
      //   3071: aconst_null
      //   3072: astore 28
      //   3074: aconst_null
      //   3075: astore 29
      //   3077: aconst_null
      //   3078: astore 30
      //   3080: aconst_null
      //   3081: astore 35
      //   3083: aconst_null
      //   3084: astore 36
      //   3086: aconst_null
      //   3087: astore 37
      //   3089: aconst_null
      //   3090: astore 38
      //   3092: aconst_null
      //   3093: astore 16
      //   3095: aload 35
      //   3097: astore 19
      //   3099: aload 15
      //   3101: astore 20
      //   3103: aload 36
      //   3105: astore 21
      //   3107: aload 15
      //   3109: astore 22
      //   3111: aload 37
      //   3113: astore 23
      //   3115: aload 15
      //   3117: astore 24
      //   3119: aload 38
      //   3121: astore 25
      //   3123: aload 15
      //   3125: astore 26
      //   3127: aload 15
      //   3129: invokeinterface 320 1 0
      //   3134: aconst_null
      //   3135: astore 34
      //   3137: aconst_null
      //   3138: astore 31
      //   3140: aconst_null
      //   3141: astore 32
      //   3143: aconst_null
      //   3144: astore 33
      //   3146: aconst_null
      //   3147: astore 20
      //   3149: aconst_null
      //   3150: astore 22
      //   3152: aconst_null
      //   3153: astore 24
      //   3155: aconst_null
      //   3156: astore 26
      //   3158: aconst_null
      //   3159: astore 15
      //   3161: aload 35
      //   3163: astore 19
      //   3165: aload 36
      //   3167: astore 21
      //   3169: aload 37
      //   3171: astore 23
      //   3173: aload 38
      //   3175: astore 25
      //   3177: aload 17
      //   3179: invokevirtual 325	java/io/InputStream:close	()V
      //   3182: iload_1
      //   3183: ifle +34 -> 3217
      //   3186: aload_0
      //   3187: getfield 28	com/tencent/mm/ak/d$b:gTA	[B
      //   3190: arraylength
      //   3191: iload_1
      //   3192: if_icmpge +25 -> 3217
      //   3195: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   3198: ldc2_w 196
      //   3201: ldc2_w 387
      //   3204: lconst_1
      //   3205: iconst_1
      //   3206: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   3209: ldc 65
      //   3211: ldc_w 390
      //   3214: invokestatic 392	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   3217: aconst_null
      //   3218: astore 16
      //   3220: aload 18
      //   3222: astore 17
      //   3224: aload 34
      //   3226: astore 15
      //   3228: goto -1910 -> 1318
      //   3231: aload 15
      //   3233: invokeinterface 282 1 0
      //   3238: astore 19
      //   3240: goto -2064 -> 1176
      //   3243: aload 15
      //   3245: invokeinterface 285 1 0
      //   3250: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   3253: astore 20
      //   3255: goto -2069 -> 1186
      //   3258: aload 15
      //   3260: invokeinterface 288 1 0
      //   3265: astore 21
      //   3267: goto -2071 -> 1196
      //   3270: aload 15
      //   3272: invokeinterface 282 1 0
      //   3277: astore 16
      //   3279: goto -1657 -> 1622
      //   3282: aload 15
      //   3284: invokeinterface 285 1 0
      //   3289: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   3292: astore 20
      //   3294: goto -1662 -> 1632
      //   3297: aload 15
      //   3299: invokeinterface 288 1 0
      //   3304: astore 21
      //   3306: goto -1664 -> 1642
      //   3309: aload 15
      //   3311: invokeinterface 282 1 0
      //   3316: astore 16
      //   3318: goto -1343 -> 1975
      //   3321: aload 15
      //   3323: invokeinterface 285 1 0
      //   3328: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   3331: astore 20
      //   3333: goto -1348 -> 1985
      //   3336: aload 15
      //   3338: invokeinterface 288 1 0
      //   3343: astore 21
      //   3345: goto -1350 -> 1995
      //   3348: aload 15
      //   3350: invokeinterface 282 1 0
      //   3355: astore 16
      //   3357: goto -1031 -> 2326
      //   3360: aload 15
      //   3362: invokeinterface 285 1 0
      //   3367: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   3370: astore 20
      //   3372: goto -1036 -> 2336
      //   3375: aload 15
      //   3377: invokeinterface 288 1 0
      //   3382: astore 21
      //   3384: goto -1038 -> 2346
      //   3387: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   3390: ldc2_w 224
      //   3393: ldc2_w 393
      //   3396: lload 5
      //   3398: iconst_0
      //   3399: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   3402: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   3405: ldc2_w 224
      //   3408: ldc2_w 395
      //   3411: lconst_1
      //   3412: iconst_0
      //   3413: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   3416: ldc 65
      //   3418: ldc_w 398
      //   3421: lload 5
      //   3423: invokestatic 335	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   3426: invokevirtual 339	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   3429: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   3432: goto -2025 -> 1407
      //   3435: astore 15
      //   3437: ldc 65
      //   3439: ldc_w 400
      //   3442: iconst_1
      //   3443: anewarray 4	java/lang/Object
      //   3446: dup
      //   3447: iconst_0
      //   3448: aload 15
      //   3450: invokestatic 406	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   3453: aastore
      //   3454: invokestatic 274	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3457: ldc 65
      //   3459: ldc_w 408
      //   3462: iconst_1
      //   3463: anewarray 4	java/lang/Object
      //   3466: dup
      //   3467: iconst_0
      //   3468: aload 15
      //   3470: invokevirtual 352	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   3473: aastore
      //   3474: invokestatic 274	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3477: getstatic 135	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   3480: ldc2_w 196
      //   3483: ldc2_w 409
      //   3486: lconst_1
      //   3487: iconst_1
      //   3488: invokevirtual 203	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   3491: goto -2084 -> 1407
      //   3494: astore 17
      //   3496: iconst_0
      //   3497: istore_3
      //   3498: lload 7
      //   3500: lstore 5
      //   3502: aload 25
      //   3504: astore 18
      //   3506: aload 16
      //   3508: astore 19
      //   3510: aload 26
      //   3512: astore 15
      //   3514: goto -1231 -> 2283
      //   3517: astore 17
      //   3519: aload 25
      //   3521: astore 18
      //   3523: aload 16
      //   3525: astore 19
      //   3527: goto -1244 -> 2283
      //   3530: astore 17
      //   3532: aload 25
      //   3534: astore 18
      //   3536: aload 16
      //   3538: astore 19
      //   3540: goto -1257 -> 2283
      //   3543: astore 15
      //   3545: aload 17
      //   3547: astore 18
      //   3549: aload 15
      //   3551: astore 17
      //   3553: aload 20
      //   3555: astore 15
      //   3557: goto -1274 -> 2283
      //   3560: astore 17
      //   3562: aconst_null
      //   3563: astore 18
      //   3565: aload 30
      //   3567: astore 19
      //   3569: aload 33
      //   3571: astore 15
      //   3573: goto -1290 -> 2283
      //   3576: astore 17
      //   3578: iconst_0
      //   3579: istore_3
      //   3580: lload 9
      //   3582: lstore 5
      //   3584: aload 24
      //   3586: astore 18
      //   3588: aload 16
      //   3590: astore 19
      //   3592: aload 21
      //   3594: astore 15
      //   3596: goto -1666 -> 1930
      //   3599: astore 17
      //   3601: aload 24
      //   3603: astore 18
      //   3605: aload 16
      //   3607: astore 19
      //   3609: goto -1679 -> 1930
      //   3612: astore 17
      //   3614: aload 24
      //   3616: astore 18
      //   3618: aload 16
      //   3620: astore 19
      //   3622: goto -1692 -> 1930
      //   3625: astore 15
      //   3627: aload 17
      //   3629: astore 18
      //   3631: aload 15
      //   3633: astore 17
      //   3635: aload 21
      //   3637: astore 19
      //   3639: aload 22
      //   3641: astore 15
      //   3643: goto -1713 -> 1930
      //   3646: astore 17
      //   3648: aconst_null
      //   3649: astore 18
      //   3651: aload 29
      //   3653: astore 19
      //   3655: aload 32
      //   3657: astore 15
      //   3659: goto -1729 -> 1930
      //   3662: astore 17
      //   3664: iconst_0
      //   3665: istore_3
      //   3666: lload 11
      //   3668: lstore 5
      //   3670: aload 23
      //   3672: astore 18
      //   3674: aload 16
      //   3676: astore 19
      //   3678: aload 20
      //   3680: astore 15
      //   3682: goto -2105 -> 1577
      //   3685: astore 17
      //   3687: aload 23
      //   3689: astore 18
      //   3691: aload 16
      //   3693: astore 19
      //   3695: goto -2118 -> 1577
      //   3698: astore 17
      //   3700: aload 23
      //   3702: astore 18
      //   3704: aload 16
      //   3706: astore 19
      //   3708: goto -2131 -> 1577
      //   3711: astore 15
      //   3713: aload 17
      //   3715: astore 18
      //   3717: aload 15
      //   3719: astore 17
      //   3721: aload 23
      //   3723: astore 19
      //   3725: aload 24
      //   3727: astore 15
      //   3729: goto -2152 -> 1577
      //   3732: astore 17
      //   3734: aconst_null
      //   3735: astore 18
      //   3737: aload 28
      //   3739: astore 19
      //   3741: aload 31
      //   3743: astore 15
      //   3745: goto -2168 -> 1577
      //   3748: astore 17
      //   3750: iconst_0
      //   3751: istore_3
      //   3752: lload 13
      //   3754: lstore 5
      //   3756: aload 22
      //   3758: astore 18
      //   3760: goto -2627 -> 1133
      //   3763: astore 17
      //   3765: aload 22
      //   3767: astore 18
      //   3769: goto -2636 -> 1133
      //   3772: astore 17
      //   3774: aload 22
      //   3776: astore 18
      //   3778: goto -2645 -> 1133
      //   3781: astore 17
      //   3783: aconst_null
      //   3784: astore 18
      //   3786: goto -2653 -> 1133
      //   3789: ldc_w 279
      //   3792: astore 17
      //   3794: goto -3583 -> 211
      //   3797: goto -3654 -> 143
      //   3800: goto -3052 -> 748
      //   3803: astore 15
      //   3805: aload 17
      //   3807: astore 18
      //   3809: aload 15
      //   3811: astore 17
      //   3813: aload 25
      //   3815: astore 16
      //   3817: aload 26
      //   3819: astore 15
      //   3821: goto -2688 -> 1133
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	3824	0	this	b
      //   155	3038	1	i	int
      //   2721	44	2	j	int
      //   60	3692	3	bool1	boolean
      //   78	2561	4	bool2	boolean
      //   288	3467	5	l1	long
      //   306	3193	7	l2	long
      //   310	3271	9	l3	long
      //   314	3353	11	l4	long
      //   318	3435	13	l5	long
      //   126	3250	15	localObject1	Object
      //   3435	34	15	localException1	Exception
      //   3512	1	15	localObject2	Object
      //   3543	7	15	localException2	Exception
      //   3555	40	15	localObject3	Object
      //   3625	7	15	localIOException1	java.io.IOException
      //   3641	40	15	localObject4	Object
      //   3711	7	15	localSocketTimeoutException1	java.net.SocketTimeoutException
      //   3727	17	15	localObject5	Object
      //   3803	7	15	localProtocolException1	java.net.ProtocolException
      //   3819	1	15	localObject6	Object
      //   273	3543	16	localObject7	Object
      //   209	906	17	localObject8	Object
      //   1123	179	17	localProtocolException2	java.net.ProtocolException
      //   1312	243	17	localObject9	Object
      //   1563	185	17	localSocketTimeoutException2	java.net.SocketTimeoutException
      //   1762	146	17	localObject10	Object
      //   1916	185	17	localIOException2	java.io.IOException
      //   2115	146	17	localObject11	Object
      //   2269	183	17	localException3	Exception
      //   2466	757	17	localObject12	Object
      //   3494	1	17	localException4	Exception
      //   3517	1	17	localException5	Exception
      //   3530	16	17	localException6	Exception
      //   3551	1	17	localException7	Exception
      //   3560	1	17	localException8	Exception
      //   3576	1	17	localIOException3	java.io.IOException
      //   3599	1	17	localIOException4	java.io.IOException
      //   3612	16	17	localIOException5	java.io.IOException
      //   3633	1	17	localIOException6	java.io.IOException
      //   3646	1	17	localIOException7	java.io.IOException
      //   3662	1	17	localSocketTimeoutException3	java.net.SocketTimeoutException
      //   3685	1	17	localSocketTimeoutException4	java.net.SocketTimeoutException
      //   3698	16	17	localSocketTimeoutException5	java.net.SocketTimeoutException
      //   3719	1	17	localSocketTimeoutException6	java.net.SocketTimeoutException
      //   3732	1	17	localSocketTimeoutException7	java.net.SocketTimeoutException
      //   3748	1	17	localProtocolException3	java.net.ProtocolException
      //   3763	1	17	localProtocolException4	java.net.ProtocolException
      //   3772	1	17	localProtocolException5	java.net.ProtocolException
      //   3781	1	17	localProtocolException6	java.net.ProtocolException
      //   3792	20	17	localObject13	Object
      //   264	3544	18	localObject14	Object
      //   246	3494	19	localObject15	Object
      //   249	3430	20	localObject16	Object
      //   255	3381	21	localObject17	Object
      //   285	3490	22	localObject18	Object
      //   276	3446	23	localObject19	Object
      //   279	3447	24	localObject20	Object
      //   282	3532	25	localObject21	Object
      //   261	3557	26	localObject22	Object
      //   45	2933	27	localObject23	Object
      //   258	3480	28	localObject24	Object
      //   252	3400	29	localObject25	Object
      //   3078	488	30	localObject26	Object
      //   3138	604	31	localObject27	Object
      //   3141	515	32	localObject28	Object
      //   3144	426	33	localObject29	Object
      //   3135	90	34	localObject30	Object
      //   3081	81	35	localObject31	Object
      //   3084	82	36	localObject32	Object
      //   3087	83	37	localObject33	Object
      //   3090	84	38	localObject34	Object
      // Exception table:
      //   from	to	target	type
      //   371	378	1123	java/net/ProtocolException
      //   419	428	1123	java/net/ProtocolException
      //   444	455	1123	java/net/ProtocolException
      //   471	481	1123	java/net/ProtocolException
      //   497	507	1123	java/net/ProtocolException
      //   523	531	1123	java/net/ProtocolException
      //   554	563	1123	java/net/ProtocolException
      //   584	598	1123	java/net/ProtocolException
      //   619	629	1123	java/net/ProtocolException
      //   645	658	1123	java/net/ProtocolException
      //   674	703	1123	java/net/ProtocolException
      //   764	778	1123	java/net/ProtocolException
      //   794	894	1123	java/net/ProtocolException
      //   935	943	1123	java/net/ProtocolException
      //   990	1004	1123	java/net/ProtocolException
      //   1020	1120	1123	java/net/ProtocolException
      //   1430	1444	1123	java/net/ProtocolException
      //   1460	1560	1123	java/net/ProtocolException
      //   1783	1797	1123	java/net/ProtocolException
      //   1813	1913	1123	java/net/ProtocolException
      //   2136	2150	1123	java/net/ProtocolException
      //   2166	2266	1123	java/net/ProtocolException
      //   2487	2502	1123	java/net/ProtocolException
      //   2521	2527	1123	java/net/ProtocolException
      //   2543	2551	1123	java/net/ProtocolException
      //   2567	2576	1123	java/net/ProtocolException
      //   371	378	1563	java/net/SocketTimeoutException
      //   419	428	1563	java/net/SocketTimeoutException
      //   444	455	1563	java/net/SocketTimeoutException
      //   471	481	1563	java/net/SocketTimeoutException
      //   497	507	1563	java/net/SocketTimeoutException
      //   523	531	1563	java/net/SocketTimeoutException
      //   554	563	1563	java/net/SocketTimeoutException
      //   584	598	1563	java/net/SocketTimeoutException
      //   619	629	1563	java/net/SocketTimeoutException
      //   645	658	1563	java/net/SocketTimeoutException
      //   674	703	1563	java/net/SocketTimeoutException
      //   764	778	1563	java/net/SocketTimeoutException
      //   794	894	1563	java/net/SocketTimeoutException
      //   935	943	1563	java/net/SocketTimeoutException
      //   990	1004	1563	java/net/SocketTimeoutException
      //   1020	1120	1563	java/net/SocketTimeoutException
      //   1430	1444	1563	java/net/SocketTimeoutException
      //   1460	1560	1563	java/net/SocketTimeoutException
      //   1783	1797	1563	java/net/SocketTimeoutException
      //   1813	1913	1563	java/net/SocketTimeoutException
      //   2136	2150	1563	java/net/SocketTimeoutException
      //   2166	2266	1563	java/net/SocketTimeoutException
      //   2487	2502	1563	java/net/SocketTimeoutException
      //   2521	2527	1563	java/net/SocketTimeoutException
      //   2543	2551	1563	java/net/SocketTimeoutException
      //   2567	2576	1563	java/net/SocketTimeoutException
      //   371	378	1916	java/io/IOException
      //   419	428	1916	java/io/IOException
      //   444	455	1916	java/io/IOException
      //   471	481	1916	java/io/IOException
      //   497	507	1916	java/io/IOException
      //   523	531	1916	java/io/IOException
      //   554	563	1916	java/io/IOException
      //   584	598	1916	java/io/IOException
      //   619	629	1916	java/io/IOException
      //   645	658	1916	java/io/IOException
      //   674	703	1916	java/io/IOException
      //   764	778	1916	java/io/IOException
      //   794	894	1916	java/io/IOException
      //   935	943	1916	java/io/IOException
      //   990	1004	1916	java/io/IOException
      //   1020	1120	1916	java/io/IOException
      //   1430	1444	1916	java/io/IOException
      //   1460	1560	1916	java/io/IOException
      //   1783	1797	1916	java/io/IOException
      //   1813	1913	1916	java/io/IOException
      //   2136	2150	1916	java/io/IOException
      //   2166	2266	1916	java/io/IOException
      //   2487	2502	1916	java/io/IOException
      //   2521	2527	1916	java/io/IOException
      //   2543	2551	1916	java/io/IOException
      //   2567	2576	1916	java/io/IOException
      //   371	378	2269	java/lang/Exception
      //   419	428	2269	java/lang/Exception
      //   444	455	2269	java/lang/Exception
      //   471	481	2269	java/lang/Exception
      //   497	507	2269	java/lang/Exception
      //   523	531	2269	java/lang/Exception
      //   554	563	2269	java/lang/Exception
      //   584	598	2269	java/lang/Exception
      //   619	629	2269	java/lang/Exception
      //   645	658	2269	java/lang/Exception
      //   674	703	2269	java/lang/Exception
      //   764	778	2269	java/lang/Exception
      //   794	894	2269	java/lang/Exception
      //   935	943	2269	java/lang/Exception
      //   990	1004	2269	java/lang/Exception
      //   1020	1120	2269	java/lang/Exception
      //   1430	1444	2269	java/lang/Exception
      //   1460	1560	2269	java/lang/Exception
      //   1783	1797	2269	java/lang/Exception
      //   1813	1913	2269	java/lang/Exception
      //   2136	2150	2269	java/lang/Exception
      //   2166	2266	2269	java/lang/Exception
      //   2487	2502	2269	java/lang/Exception
      //   2521	2527	2269	java/lang/Exception
      //   2543	2551	2269	java/lang/Exception
      //   2567	2576	2269	java/lang/Exception
      //   1323	1330	3435	java/lang/Exception
      //   1335	1340	3435	java/lang/Exception
      //   1345	1350	3435	java/lang/Exception
      //   1350	1358	3435	java/lang/Exception
      //   1362	1407	3435	java/lang/Exception
      //   3387	3432	3435	java/lang/Exception
      //   320	325	3494	java/lang/Exception
      //   341	359	3494	java/lang/Exception
      //   378	403	3517	java/lang/Exception
      //   943	957	3530	java/lang/Exception
      //   2613	2630	3543	java/lang/Exception
      //   2675	2682	3543	java/lang/Exception
      //   2714	2722	3543	java/lang/Exception
      //   2759	2768	3543	java/lang/Exception
      //   2803	2817	3543	java/lang/Exception
      //   2849	2855	3543	java/lang/Exception
      //   2887	2990	3543	java/lang/Exception
      //   3022	3031	3543	java/lang/Exception
      //   3063	3068	3543	java/lang/Exception
      //   3127	3134	3543	java/lang/Exception
      //   3177	3182	3543	java/lang/Exception
      //   3186	3217	3560	java/lang/Exception
      //   320	325	3576	java/io/IOException
      //   341	359	3576	java/io/IOException
      //   378	403	3599	java/io/IOException
      //   943	957	3612	java/io/IOException
      //   2613	2630	3625	java/io/IOException
      //   2675	2682	3625	java/io/IOException
      //   2714	2722	3625	java/io/IOException
      //   2759	2768	3625	java/io/IOException
      //   2803	2817	3625	java/io/IOException
      //   2849	2855	3625	java/io/IOException
      //   2887	2990	3625	java/io/IOException
      //   3022	3031	3625	java/io/IOException
      //   3063	3068	3625	java/io/IOException
      //   3127	3134	3625	java/io/IOException
      //   3177	3182	3625	java/io/IOException
      //   3186	3217	3646	java/io/IOException
      //   320	325	3662	java/net/SocketTimeoutException
      //   341	359	3662	java/net/SocketTimeoutException
      //   378	403	3685	java/net/SocketTimeoutException
      //   943	957	3698	java/net/SocketTimeoutException
      //   2613	2630	3711	java/net/SocketTimeoutException
      //   2675	2682	3711	java/net/SocketTimeoutException
      //   2714	2722	3711	java/net/SocketTimeoutException
      //   2759	2768	3711	java/net/SocketTimeoutException
      //   2803	2817	3711	java/net/SocketTimeoutException
      //   2849	2855	3711	java/net/SocketTimeoutException
      //   2887	2990	3711	java/net/SocketTimeoutException
      //   3022	3031	3711	java/net/SocketTimeoutException
      //   3063	3068	3711	java/net/SocketTimeoutException
      //   3127	3134	3711	java/net/SocketTimeoutException
      //   3177	3182	3711	java/net/SocketTimeoutException
      //   3186	3217	3732	java/net/SocketTimeoutException
      //   320	325	3748	java/net/ProtocolException
      //   341	359	3748	java/net/ProtocolException
      //   378	403	3763	java/net/ProtocolException
      //   943	957	3772	java/net/ProtocolException
      //   3186	3217	3781	java/net/ProtocolException
      //   2613	2630	3803	java/net/ProtocolException
      //   2675	2682	3803	java/net/ProtocolException
      //   2714	2722	3803	java/net/ProtocolException
      //   2759	2768	3803	java/net/ProtocolException
      //   2803	2817	3803	java/net/ProtocolException
      //   2849	2855	3803	java/net/ProtocolException
      //   2887	2990	3803	java/net/ProtocolException
      //   3022	3031	3803	java/net/ProtocolException
      //   3063	3068	3803	java/net/ProtocolException
      //   3127	3134	3803	java/net/ProtocolException
      //   3177	3182	3803	java/net/ProtocolException
    }
    
    public final boolean aut()
    {
      AppMethodBeat.i(150221);
      if ((this.gTz == null) || (bt.isNullOrNil(this.gTz.getUsername())))
      {
        AppMethodBeat.o(150221);
        return false;
      }
      if (bt.cw(this.gTA))
      {
        d.this.gTl.remove(this.gTz.getUsername());
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(138L, 10L, 1L, true);
        AppMethodBeat.o(150221);
        return false;
      }
      if (ar.a.gMX != null) {
        ar.a.gMX.cZ(this.gTA.length, 0);
      }
      d.this.a(new d.a(d.this, this.gTz, this.gTA, this.bym));
      AppMethodBeat.o(150221);
      return false;
    }
  }
  
  final class c
    implements be.a
  {
    Bitmap gTB = null;
    b gTC = null;
    String username = null;
    
    public c(String paramString)
    {
      this.username = paramString;
    }
    
    public c(String paramString, b paramb)
    {
      this.username = paramString;
      this.gTC = paramb;
    }
    
    public final boolean aus()
    {
      Context localContext = null;
      Object localObject1 = null;
      int i = 0;
      AppMethodBeat.i(150222);
      if (bt.isNullOrNil(this.username))
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
          str2 = (String)d.this.gTr.get(str1);
          if (!bt.isNullOrNil(str2))
          {
            localObject2 = p.auF().we(str1);
            if ((localObject2 == null) || (!str1.equals(((i)localObject2).getUsername())))
            {
              localObject2 = p.auF();
              String str3 = "select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + bt.aFQ(str2) + "\"";
              localObject2 = ((j)localObject2).gPa.a(str3, null, 2);
              if (localObject2 != null) {
                break label263;
              }
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && (!bt.isNullOrNil(((i)localObject1).getUsername()))) {
          com.tencent.mm.vfs.i.lC(c.vN(((i)localObject1).getUsername()), c.vN(str1));
        }
        localObject1 = new i();
        ((i)localObject1).username = str1;
        ((i)localObject1).evo = 3;
        ((i)localObject1).gUf = str2;
        ((i)localObject1).gUg = str2;
        ((i)localObject1).dtM = 3;
        ((i)localObject1).ee(true);
        ((i)localObject1).dtM = 31;
        p.auF().b((i)localObject1);
        localObject1 = d.auq();
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
      if (e.gTF.containsKey(this.username)) {
        i = ((Integer)e.gTF.get(this.username)).intValue();
      }
      if (i != 0)
      {
        p.auE();
        localContext = p.getContext();
        if (localContext != null) {
          ((e)localObject1).f(this.username, com.tencent.mm.compatible.e.a.decodeResource(localContext.getResources(), i));
        }
      }
      this.gTB = e.vV(this.username);
      AppMethodBeat.o(150222);
      return true;
    }
    
    public final boolean aut()
    {
      AppMethodBeat.i(150223);
      if (this.gTB == null)
      {
        d locald = d.this;
        String str = this.username;
        b localb = this.gTC;
        ad.d("MicroMsg.AvatarService", "avatar service push: %s", new Object[] { str });
        if (bt.isNullOrNil(str))
        {
          localObject = null;
          if (localObject != null) {
            break label481;
          }
          locald.gTl.remove(str);
        }
        for (;;)
        {
          AppMethodBeat.o(150223);
          return false;
          if ((str.equals(locald.gTq + "@bottle")) && (!bt.a((Boolean)com.tencent.mm.kernel.g.afB().afk().get(60, null), false)))
          {
            localObject = null;
            break;
          }
          if ((str.equals(locald.gTq)) && (!bt.a((Boolean)com.tencent.mm.kernel.g.afB().afk().get(59, null), false)))
          {
            ad.w("MicroMsg.AvatarService", "ConstantsStorage.USERINFO_HAS_HEADIMG false");
            localObject = null;
            break;
          }
          long l = bt.aGK();
          d.d locald1 = (d.d)locald.gTm.aM(str);
          if ((locald1 != null) && (locald1.gll >= 5) && (l - locald1.glk < 600L))
          {
            ad.w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", new Object[] { str });
            localObject = null;
            break;
          }
          localObject = d.vR(str);
          if (localObject == null)
          {
            ad.w("MicroMsg.AvatarService", "checkUser block local no need: %s", new Object[] { str });
            localObject = new d.d((byte)0);
            ((d.d)localObject).gll = 5;
            ((d.d)localObject).glk = l;
            locald.gTm.o(str, localObject);
            localObject = null;
            break;
          }
          if ((locald1 == null) || (l - locald1.glk > 600L))
          {
            ad.i("MicroMsg.AvatarService", "new user: %s", new Object[] { str });
            locald1 = new d.d((byte)0);
            locald1.gll = 1;
            locald1.glk = l;
            locald.gTm.o(str, locald1);
          }
          for (;;)
          {
            break;
            if (locald1.gll < 5)
            {
              ad.i("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", new Object[] { str, Integer.valueOf(locald1.gll), Long.valueOf(l - locald1.glk) });
              locald1.gll += 1;
              locald1.glk = l;
              locald.gTm.o(str, locald1);
            }
          }
          label481:
          if (!bt.isNullOrNil(((i)localObject).auy()))
          {
            locald.a(new d.b(locald, (i)localObject));
          }
          else
          {
            ad.w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", new Object[] { str, Integer.valueOf(((i)localObject).evo) });
            if (4 == ((i)localObject).evo)
            {
              ad.w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
            }
            else if ((localb != null) && (!localb.gTh))
            {
              ad.w("MicroMsg.AvatarService", "avatar push username %s can not get avatar by username", new Object[] { str });
              locald.gTl.remove(str);
            }
            else
            {
              locald.gTn.push(localObject);
              if (locald.gTn.size() > 5) {
                locald.gTs.av(0L, 0L);
              } else {
                locald.gTs.av(1000L, 1000L);
              }
            }
          }
        }
      }
      Object localObject = d.auq();
      if (localObject != null) {
        ((e)localObject).e(this.username, this.gTB);
      }
      d.this.gTl.remove(this.username);
      AppMethodBeat.o(150223);
      return false;
    }
  }
  
  static final class d
  {
    public long glk = 0L;
    public int gll = 0;
  }
  
  final class e
    implements be.a
  {
    Bitmap bitmap = null;
    byte[] buf;
    i gTw = null;
    
    public e(i parami, byte[] paramArrayOfByte)
    {
      this.gTw = parami;
      this.buf = paramArrayOfByte;
    }
    
    public final boolean aus()
    {
      AppMethodBeat.i(150224);
      if ((this.gTw == null) || (bt.isNullOrNil(this.gTw.getUsername())))
      {
        ad.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(138L, 13L, 1L, true);
        AppMethodBeat.o(150224);
        return false;
      }
      if (d.auq() != null)
      {
        this.bitmap = e.g(this.gTw.getUsername(), this.buf);
        if (this.bitmap == null) {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(138L, 14L, 1L, true);
        }
      }
      j localj = d.aur();
      if (localj != null)
      {
        this.gTw.dtM = -1;
        this.gTw.auz();
        localj.b(this.gTw);
      }
      AppMethodBeat.o(150224);
      return true;
    }
    
    public final boolean aut()
    {
      AppMethodBeat.i(150225);
      if (bt.isNullOrNil(this.gTw.getUsername()))
      {
        AppMethodBeat.o(150225);
        return false;
      }
      e locale = d.auq();
      if ((locale != null) && (this.bitmap != null)) {
        locale.e(this.gTw.getUsername(), this.bitmap);
      }
      d.this.gTl.remove(this.gTw.getUsername());
      AppMethodBeat.o(150225);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.d
 * JD-Core Version:    0.7.0.1
 */