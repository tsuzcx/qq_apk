package com.tencent.mm.plugin.byp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.modelvideo.h;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dth;
import com.tencent.mm.protocal.protobuf.dti;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.rj;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSendVideo;", "Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend;", "bizType", "", "session_id", "", "from_username", "to_username", "fakeScene", "Lcom/tencent/mm/modelvideo/NetSceneUploadVideoForCdn;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelvideo/NetSceneUploadVideoForCdn;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-byp_release"})
public final class d
  extends a
{
  private static final boolean cFj;
  public static final d.a ovr;
  private final int ePC = 1;
  private final String ovl;
  private final String ovm;
  private final h ovq;
  private final String session_id;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(219227);
    ovr = new d.a((byte)0);
    if (i.DEBUG) {
      bool = true;
    }
    cFj = bool;
    AppMethodBeat.o(219227);
  }
  
  public d(String paramString1, String paramString2, String paramString3, h paramh)
  {
    super(1, localrh);
    this.session_id = paramString1;
    this.ovl = paramString2;
    this.ovm = paramString3;
    this.ovq = paramh;
    AppMethodBeat.o(219226);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(219224);
    Object localObject = u.Hy(this.ovq.getFileName());
    if (localObject == null)
    {
      ad.e("Byp.CgiBypSendVideo", "null == info %s", new Object[] { this.ovq.getFileName() });
      this.ovq.icP.dg(3, -1);
      AppMethodBeat.o(219224);
      return -1;
    }
    paramf = this.ovq.a((s)localObject, paramf);
    this.ovj.FNt = paramf.Fvn;
    localObject = this.ovj.FNx;
    ((rj)localObject).aeskey = paramf.FOH;
    ((rj)localObject).url = paramf.HFY;
    ((rj)localObject).type = 43;
    ((rj)localObject).length = paramf.HFV;
    ((rj)localObject).FNy = paramf.Hsd;
    ((rj)localObject).FNz = paramf.GJN;
    ((rj)localObject).FNA = paramf.GJL;
    ((rj)localObject).FNl = paramf.HFN;
    ((rj)localObject).AsE = paramf.HFP;
    ((rj)localObject).AsF = paramf.HFO;
    ((rj)localObject).md5 = paramf.HGa;
    ((rj)localObject).FNC = paramf.HGk;
    paramf = this.ovq.icO;
    if (paramf != null) {}
    for (paramf = Integer.valueOf(paramf.field_videoFormat);; paramf = null)
    {
      ((rj)localObject).FNB = String.valueOf(paramf);
      ad.i("Byp.CgiBypSendVideo", "[doScene] " + ((rj)localObject).AsE + ':' + ((rj)localObject).AsF + ", " + this.ovq.getFileName());
      int i = dispatch(parame, (q)this.gPp, (k)this);
      AppMethodBeat.o(219224);
      return i;
    }
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(219225);
    p.h(paramq, "rr");
    paramArrayOfByte = new dti();
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BypSendResponse");
      AppMethodBeat.o(219225);
      throw paramString;
    }
    paramq = (rm)paramq;
    paramArrayOfByte.xbt = paramq.FNG;
    ad.i("Byp.CgiBypSendVideo", "[onCgiBack] errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString + " newmsgid=" + paramq.FNG);
    this.ovq.a(paramInt2, paramInt3, paramString, paramArrayOfByte, (n)this);
    AppMethodBeat.o(219225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b.d
 * JD-Core Version:    0.7.0.1
 */