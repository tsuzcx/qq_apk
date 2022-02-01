package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.hw;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  private g callback;
  public com.tencent.mm.network.q hwy;
  
  public a(LinkedList<za> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(21370);
    this.hwy = new a();
    k.a locala = (k.a)this.hwy.getReqObj();
    boolean bool = this.hwy.isSingleSession();
    locala.DIN = d.bCT();
    locala.DIM.DVc = paramLinkedList.size();
    locala.DIM.DVd = paramLinkedList;
    locala.DIM.DVe = com.tencent.mm.compatible.deviceinfo.q.Ya();
    locala.DIM.DVf = u.axw();
    locala.DIM.Scene = 2;
    locala.DIM.ndf = 0L;
    locala.DIM.DVg = paramString1;
    locala.DIM.DVh = paramString2;
    locala.setPassKey(locala.DIN);
    if (!bool) {
      locala.DIO = locala.DIN;
    }
    locala.setReqPackControl(new a.1(this, locala, bool));
    AppMethodBeat.o(21370);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(21371);
    this.callback = paramg;
    int i = dispatch(parame, this.hwy, this);
    AppMethodBeat.o(21371);
    return i;
  }
  
  public final int getType()
  {
    return 1000;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21372);
    ac.i("MicroMsg.BackupCreateQRCodeOfflineScene", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(21372);
      return;
    }
    ac.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { ((k.b)paramq.getRespObj()).DIP.DVj });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21372);
  }
  
  public static final class a
    extends l
  {
    private final k.a mVM;
    private final k.b mVN;
    
    public a()
    {
      AppMethodBeat.i(21369);
      this.mVM = new k.a();
      this.mVN = new k.b();
      AppMethodBeat.o(21369);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.mVM;
    }
    
    public final l.e getRespObj()
    {
      return this.mVN;
    }
    
    public final int getType()
    {
      return 1000;
    }
    
    public final String getUri()
    {
      return "/cgi-bin/micromsg-bin/bakchatcreateqrcodeoffline";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.a
 * JD-Core Version:    0.7.0.1
 */