package com.tencent.mm.plugin.exdevice.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import junit.framework.Assert;

public final class k
  implements com.tencent.mm.ai.f
{
  public static k lCB = null;
  private final HashMap<Long, e> lCA;
  public HashMap<String, Integer> lCC;
  public ak mHandler;
  
  private k()
  {
    AppMethodBeat.i(19064);
    this.lCA = new HashMap();
    this.mHandler = null;
    this.lCC = new HashMap();
    this.mHandler = new k.a(this, aw.RO().oNc.getLooper());
    AppMethodBeat.o(19064);
  }
  
  public static k bpz()
  {
    AppMethodBeat.i(19063);
    if (lCB != null)
    {
      localk = lCB;
      AppMethodBeat.o(19063);
      return localk;
    }
    k localk = new k();
    lCB = localk;
    AppMethodBeat.o(19063);
    return localk;
  }
  
  public final void b(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19065);
    paramArrayOfByte = new f(paramLong, paramInt2, paramInt3, paramArrayOfByte);
    this.mHandler.obtainMessage(1, paramInt1, 0, paramArrayOfByte).sendToTarget();
    AppMethodBeat.o(19065);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(19066);
    ab.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "******onSceneEnd******\r\n errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    k.b localb = new k.b((byte)0);
    localb.lCs = paramInt2;
    localb.lCE = paramInt1;
    localb.hyJ = paramString;
    localb.lCF = paramm;
    this.mHandler.obtainMessage(2, localb).sendToTarget();
    AppMethodBeat.o(19066);
  }
  
  public static final class c
  {
    public byte[] mData = null;
    public long mSessionId = 0L;
  }
  
  final class d
    implements Runnable
  {
    private long lCG;
    
    public d(long paramLong)
    {
      AppMethodBeat.i(19055);
      this.lCG = -1L;
      if (paramLong >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.lCG = paramLong;
        AppMethodBeat.o(19055);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(19056);
      ab.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Time Out Sequnence(%d)", new Object[] { Long.valueOf(this.lCG) });
      k.a(k.this).obtainMessage(0, Long.valueOf(this.lCG)).sendToTarget();
      AppMethodBeat.o(19056);
    }
  }
  
  static final class e
  {
    f lCH = null;
    private k.d lCI = null;
    int lCJ = 0;
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(19057);
      Assert.assertNotNull(paramf);
      this.lCH = paramf;
      AppMethodBeat.o(19057);
    }
    
    public final void a(k.d paramd)
    {
      AppMethodBeat.i(19058);
      Assert.assertNotNull(paramd);
      this.lCI = paramd;
      AppMethodBeat.o(19058);
    }
    
    public final f bpA()
    {
      AppMethodBeat.i(19059);
      Assert.assertNotNull(this.lCH);
      f localf = this.lCH;
      AppMethodBeat.o(19059);
      return localf;
    }
    
    public final k.d bpB()
    {
      AppMethodBeat.i(19060);
      Assert.assertNotNull(this.lCI);
      k.d locald = this.lCI;
      AppMethodBeat.o(19060);
      return locald;
    }
  }
  
  public static final class f
  {
    private static f lCL = null;
    private long lCK;
    
    public f()
    {
      AppMethodBeat.i(19061);
      SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("exdevice_pref", 0);
      if (localSharedPreferences != null)
      {
        l = localSharedPreferences.getLong("local_message_seq", 0L);
        ab.i("MicroMsg.exdevice.Util", "lasted seq id is %d", new Object[] { Long.valueOf(l) });
      }
      this.lCK = l;
      AppMethodBeat.o(19061);
    }
    
    public static long bpC()
    {
      AppMethodBeat.i(19062);
      if (lCL == null) {
        lCL = new f();
      }
      Object localObject = lCL;
      if (9223372036854775807L == ((f)localObject).lCK)
      {
        ab.w("MicroMsg.MMSendDataToManufacturerLogic", "Sequence Data-overrun!!!");
        ((f)localObject).lCK = 0L;
      }
      long l = ((f)localObject).lCK + 1L;
      ((f)localObject).lCK = l;
      localObject = ah.getContext().getSharedPreferences("exdevice_pref", 0);
      if (localObject != null)
      {
        ab.i("MicroMsg.exdevice.Util", "save locall seq id : %d", new Object[] { Long.valueOf(l) });
        ((SharedPreferences)localObject).edit().putLong("local_message_seq", l).commit();
      }
      AppMethodBeat.o(19062);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.k
 * JD-Core Version:    0.7.0.1
 */