package com.tencent.mm.plugin.byp.b;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.o.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.i.d;
import com.tencent.mm.model.cf;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSendImage;", "Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend;", "bizType", "", "session_id", "", "from_username", "to_username", "params", "Lcom/tencent/mm/modelimage/CdnImageSendMsgParams;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelimage/CdnImageSendMsgParams;)V", "onSendFailed", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/BypSendResponse;", "onSendSuccessfully", "Companion", "plugin-byp_release"})
public final class b
  extends a
{
  private static final boolean cFj;
  public static final b.a ovo;
  private final int ePC = 1;
  private final String ovl;
  private final String ovm;
  private final c ovn;
  private final String session_id;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(219219);
    ovo = new b.a((byte)0);
    if (com.tencent.mm.sdk.platformtools.i.DEBUG) {
      bool = true;
    }
    cFj = bool;
    AppMethodBeat.o(219219);
  }
  
  public b(String paramString1, String paramString2, String paramString3, c paramc)
  {
    super(1, localrh);
    this.session_id = paramString1;
    this.ovl = paramString2;
    this.ovm = paramString3;
    this.ovn = paramc;
    paramString2 = this.ovj.FNw;
    paramString3 = this.ovn.gwW;
    if (paramString3 != null)
    {
      if (!paramString3.XO()) {
        break label935;
      }
      paramString2.aeskey = "";
      ad.i("Byp.CgiBypSendImage", "hit SafeCDNWithMD5. " + this.ovj.Fsc);
      paramString2.FNi = 1;
      paramString2.url = paramString3.field_fileId;
      paramString2.md5 = paramString3.field_filemd5;
      paramString1 = this.ovn.hZh;
      p.g(paramString1, "params.imgInfo");
      paramString1 = (CharSequence)paramString1.aIg();
      if ((paramString1 != null) && (!n.aE(paramString1))) {
        break label969;
      }
      i = 1;
      label287:
      if (i == 0)
      {
        paramString1 = this.ovn.hZh;
        p.g(paramString1, "params.imgInfo");
        paramString1 = (CharSequence)paramString1.aIf();
        if ((paramString1 != null) && (!n.aE(paramString1))) {
          break label975;
        }
        i = 1;
        label328:
        if (i == 0)
        {
          paramString2.FNj = ((int)paramString3.field_fileLength);
          paramString1 = q.aIF();
          paramc = this.ovn.hZh;
          p.g(paramc, "params.imgInfo");
          paramString1 = com.tencent.mm.sdk.platformtools.g.aQc(paramString1.o(paramc.aIf(), "", ""));
          if (paramString1 == null) {
            break label981;
          }
          i = paramString1.outWidth;
          paramString2.FNp = i;
          if (paramString1 == null) {
            break label987;
          }
          i = paramString1.outHeight;
          paramString2.FNo = i;
        }
      }
      label389:
      label405:
      paramString1 = q.aIF();
      paramc = this.ovn.hZh;
      p.g(paramc, "params.imgInfo");
      paramString1 = com.tencent.mm.sdk.platformtools.g.aQc(paramString1.o(paramc.aIh(), "", ""));
      paramString2.FNl = paramString3.field_thumbimgLength;
      if (paramString1 == null) {
        break label993;
      }
      i = paramString1.outWidth;
      label466:
      paramString2.AsE = i;
      if (paramString1 == null) {
        break label999;
      }
      i = paramString1.outHeight;
      label482:
      paramString2.AsF = i;
      paramString1 = this.ovn.hZh;
      p.g(paramString1, "params.imgInfo");
      paramString1 = (CharSequence)paramString1.aIg();
      if ((paramString1 != null) && (!n.aE(paramString1))) {
        break label1005;
      }
      i = 1;
      label524:
      if (i == 0) {
        break label1029;
      }
      paramString1 = this.ovn.hZh;
      p.g(paramString1, "params.imgInfo");
      paramString1 = (CharSequence)paramString1.aIf();
      if ((paramString1 != null) && (!n.aE(paramString1))) {
        break label1011;
      }
      i = 1;
      label565:
      if (i != 0) {
        break label1029;
      }
      paramString1 = q.aIF();
      paramc = this.ovn.hZh;
      p.g(paramc, "params.imgInfo");
      paramString1 = com.tencent.mm.sdk.platformtools.g.aQc(paramString1.o(paramc.aIf(), "", ""));
      paramString2.FNk = ((int)paramString3.field_fileLength);
      if (paramString1 == null) {
        break label1017;
      }
      i = paramString1.outWidth;
      label626:
      paramString2.FNm = i;
      if (paramString1 == null) {
        break label1023;
      }
    }
    label935:
    label969:
    label975:
    label981:
    label987:
    label993:
    label999:
    label1005:
    label1011:
    label1017:
    label1023:
    for (int i = paramString1.outHeight;; i = 0)
    {
      paramString2.FNn = i;
      paramString2.FNq = 0;
      paramString2.FNr = 0;
      paramString2.FNs = 0;
      paramString1 = new StringBuilder().append(this.ovj.Fsc).append(", ");
      p.g(paramString2, "bypImage");
      p.h(paramString2, "$this$print");
      ad.i("Byp.CgiBypSendImage", new StringBuilder("aeskey=").append(paramString2.aeskey).append(", crypt_ver=").append(paramString2.FNi).append(", url=").append(paramString2.url).append(", hd_size=").append(paramString2.FNj).append(", mid_size=").append(paramString2.FNk).append(", thumb_size=").append(paramString2.FNl).append(", thumb_height=").append(paramString2.AsF).append(", thumb_width=").append(paramString2.AsE).append(", md5=").append(paramString2.md5).append(", mid_height=").append(paramString2.FNm).append(", mid_width=").append(paramString2.FNn).append(", hd_height=").append(paramString2.FNo).append(", hd_width=").append(paramString2.FNp).append(", hevc_hd_size=").append(paramString2.FNq).append(", hevc_mid_size=").append(paramString2.FNr).append(", hevc_thumb_size=").append(paramString2.FNs).toString());
      AppMethodBeat.o(219218);
      return;
      if (bt.isNullOrNil(paramString3.field_aesKey)) {}
      for (paramString1 = this.ovn.gjI;; paramString1 = paramString3.field_aesKey)
      {
        paramString2.aeskey = paramString1;
        break;
      }
      i = 0;
      break label287;
      i = 0;
      break label328;
      i = 0;
      break label389;
      i = 0;
      break label405;
      i = 0;
      break label466;
      i = 0;
      break label482;
      i = 0;
      break label524;
      i = 0;
      break label565;
      i = 0;
      break label626;
    }
    label1029:
    paramString1 = this.ovn.hZh;
    p.g(paramString1, "params.imgInfo");
    paramString1 = (CharSequence)paramString1.aIg();
    if ((paramString1 == null) || (n.aE(paramString1)))
    {
      i = 1;
      label1065:
      if (i != 0) {
        break label1196;
      }
      paramString1 = this.ovn.hZh;
      p.g(paramString1, "params.imgInfo");
      paramString1 = (CharSequence)paramString1.aIf();
      if ((paramString1 != null) && (!n.aE(paramString1))) {
        break label1198;
      }
      i = 1;
      label1106:
      if (i != 0) {
        break label1202;
      }
      paramString1 = q.aIF();
      paramc = this.ovn.hZh;
      p.g(paramc, "params.imgInfo");
      paramString1 = com.tencent.mm.sdk.platformtools.g.aQc(paramString1.o(paramc.aIg(), "", ""));
      paramString2.FNk = ((int)paramString3.field_fileLength);
      if (paramString1 == null) {
        break label1204;
      }
      i = paramString1.outWidth;
      label1167:
      paramString2.FNm = i;
      if (paramString1 == null) {
        break label1210;
      }
    }
    label1196:
    label1198:
    label1202:
    label1204:
    label1210:
    for (i = paramString1.outHeight;; i = 0)
    {
      paramString2.FNn = i;
      break;
      i = 0;
      break label1065;
      break;
      i = 0;
      break label1106;
      break;
      i = 0;
      break label1167;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, rm paramrm)
  {
    AppMethodBeat.i(219217);
    p.h(paramrm, "resp");
    ad.e("Byp.CgiBypSendText", "[onSendFailed] bizType=" + this.ePC + " sessionId=" + this.session_id + " toUsername=" + this.ovm + " fromUsername=" + this.ovl);
    this.ovn.hZi.a(paramrm.FNG, cf.aCN(), paramInt1, paramInt2, "");
    AppMethodBeat.o(219217);
  }
  
  public final void a(rm paramrm)
  {
    AppMethodBeat.i(219216);
    p.h(paramrm, "resp");
    ad.i("Byp.CgiBypSendImage", "[onSendSuccessfully] bizType=" + this.ePC + " msgSvrId=" + paramrm.FNG + "  sessionId=" + this.session_id + " toUsername=" + this.ovm + " fromUsername=" + this.ovl);
    this.ovn.hZi.a(paramrm.FNG, cf.aCN(), 0, 0, "");
    AppMethodBeat.o(219216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b.b
 * JD-Core Version:    0.7.0.1
 */