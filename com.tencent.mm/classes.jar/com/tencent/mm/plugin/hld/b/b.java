package com.tencent.mm.plugin.hld.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.bx.a;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.e;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.foz;
import com.tencent.mm.protocal.protobuf.fpd;
import com.tencent.mm.protocal.protobuf.fqe;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/cgi/CgiImeGetImeDictListConfig;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetImeDictListConfigResp;", "dictInfos", "Lcom/tencent/mm/protocal/protobuf/ImeLocalClientStaticDictInfos;", "rawDictInfo", "Lcom/tencent/mm/protocal/protobuf/ImeLocalRawDictInfos;", "(Lcom/tencent/mm/protocal/protobuf/ImeLocalClientStaticDictInfos;Lcom/tencent/mm/protocal/protobuf/ImeLocalRawDictInfos;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.am.b<clh>
{
  public static final b.a JoF;
  
  static
  {
    AppMethodBeat.i(312107);
    JoF = new b.a((byte)0);
    AppMethodBeat.o(312107);
  }
  
  private b(dbo paramdbo)
  {
    AppMethodBeat.i(312077);
    Object localObject1 = l.JyV;
    boolean bool2 = l.bGa();
    c.a locala = new c.a();
    localObject1 = new clg();
    ((clg)localObject1).aatk = e.JuE.value;
    ((clg)localObject1).aatl = com.tencent.mm.plugin.hld.model.d.Juz.value;
    Object localObject2 = n.JvW;
    ((clg)localObject1).aatm = n.fMW();
    localObject2 = (com.tencent.mm.plugin.hld.a.d)h.ax(com.tencent.mm.plugin.hld.a.d.class);
    int i;
    boolean bool1;
    label106:
    Object localObject3;
    if ((localObject2 != null) && (((com.tencent.mm.plugin.hld.a.d)localObject2).fKF() == true))
    {
      i = 1;
      if (i != 0) {
        break label388;
      }
      bool1 = true;
      ((clg)localObject1).aatn = bool1;
      localObject2 = i.JyA;
      if (i.fOo()) {
        break label393;
      }
      localObject2 = new enu();
      localObject3 = aj.dch();
      if (localObject3 != null)
      {
        ((enu)localObject2).longitude = ((dhb)localObject3).ZaG;
        ((enu)localObject2).latitude = ((dhb)localObject3).ZaH;
      }
      Log.i("WxIme.CgiImeGetImeDictListConfig", " loc:[" + ((enu)localObject2).longitude + ", " + ((enu)localObject2).latitude + ']');
      localObject3 = ah.aiuX;
      ((clg)localObject1).aato = ((enu)localObject2);
      ((clg)localObject1).aatp = true;
      label225:
      if (paramdbo != null)
      {
        paramdbo = paramdbo.aatr;
        if (paramdbo != null) {
          ((clg)localObject1).aatr = paramdbo;
        }
      }
      paramdbo = new clh();
      paramdbo.setBaseResponse(new kd());
      paramdbo.getBaseResponse().akjO = new etl();
      locala.otE = ((a)localObject1);
      locala.otF = ((a)paramdbo);
      if (!bool2) {
        break label402;
      }
      locala.uri = "/cgi-bin/mmsprime/getimedictlistconfig";
      locala.funcId = 4872;
      c(locala.bEF());
    }
    for (;;)
    {
      Log.i("WxIme.CgiImeGetImeDictListConfig", "isLogin:" + bool2 + " is_initializing:" + ((clg)localObject1).aatn + " engineVersion:" + ((clg)localObject1).aatm);
      AppMethodBeat.o(312077);
      return;
      i = 0;
      break;
      label388:
      bool1 = false;
      break label106;
      label393:
      ((clg)localObject1).aatp = false;
      break label225;
      label402:
      locala.uri = "/cgi-bin/mmsprime/getimedictlistconfignonlogin";
      locala.funcId = 5126;
      localObject2 = new fpd();
      localObject3 = new fqe();
      ((fqe)localObject3).abPT = new gol();
      Object localObject4 = ah.aiuX;
      ((fpd)localObject2).abPg = ((fqe)localObject3);
      localObject3 = new foz();
      localObject4 = locala.bEF().getReqObj();
      if ((localObject4 instanceof c.b))
      {
        ((c.b)localObject4).toProtoBuf();
        ((foz)localObject3).BaseRequest = ((clg)localObject1).getBaseRequest();
        ((foz)localObject3).abPd = w.aN(((clg)localObject1).toByteArray());
      }
      localObject4 = ah.aiuX;
      ((fpd)localObject2).abPh = ((foz)localObject3);
      locala.otE = ((a)localObject2);
      locala.otF = ((a)paramdbo);
      paramdbo = locala.bEF();
      paramdbo.getReqObj().setReqPackControl(new b..ExternalSyntheticLambda0(paramdbo));
      paramdbo.option = 1;
      paramdbo.getReqObj().setUseECDH(false);
      c(paramdbo);
    }
  }
  
  private static final boolean a(c paramc, PByteArray paramPByteArray, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(312099);
    Log.i("WxIme.CgiImeGetImeDictListConfig", "reqPackControl");
    paramArrayOfByte1 = paramc.getReqObj();
    paramc = c.b.b(paramc.otB);
    if (paramc == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.TransferEncryptReq");
      AppMethodBeat.o(312099);
      throw paramc;
    }
    paramc = (fpd)paramc;
    long l = f.cZ(null);
    paramArrayOfByte1.setEcdhEngine(l);
    paramc = UtilsJni.HybridEcdhEncrypt(l, paramc.toByteArray());
    paramBoolean = MMProtocalJni.packHybridEcdh(paramPByteArray, paramArrayOfByte2, paramArrayOfByte1.getDeviceID(), paramArrayOfByte1.getUin(), 5126, f.iPL(), paramc, paramInt3, paramInt4, 12);
    Log.i("WxIme.CgiImeGetImeDictListConfig", "summerauths reqToBuf packHybridEcdh using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(f.iPL()), Integer.valueOf(paramPByteArray.value.length), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(312099);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.b.b
 * JD-Core Version:    0.7.0.1
 */