package com.tencent.mm.plugin.hld.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.cd.a;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.model.e;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.a;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.bwd;
import com.tencent.mm.protocal.protobuf.bwe;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.protocal.protobuf.cqh;
import com.tencent.mm.protocal.protobuf.duw;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eto;
import com.tencent.mm.protocal.protobuf.ets;
import com.tencent.mm.protocal.protobuf.eur;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/cgi/CgiImeGetImeDictListConfig;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetImeDictListConfigResp;", "dictInfos", "Lcom/tencent/mm/protocal/protobuf/ImeLocalClientStaticDictInfos;", "rawDictInfo", "Lcom/tencent/mm/protocal/protobuf/ImeLocalRawDictInfos;", "(Lcom/tencent/mm/protocal/protobuf/ImeLocalClientStaticDictInfos;Lcom/tencent/mm/protocal/protobuf/ImeLocalRawDictInfos;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-hld_release"})
public final class b
  extends c<bwe>
{
  public static final a Dvl;
  
  static
  {
    AppMethodBeat.i(216836);
    Dvl = new a((byte)0);
    AppMethodBeat.o(216836);
  }
  
  private b(clg paramclg)
  {
    AppMethodBeat.i(216834);
    Object localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
    boolean bool2 = com.tencent.mm.plugin.hld.f.l.biq();
    d.a locala = new d.a();
    localObject1 = new bwd();
    ((bwd)localObject1).TfQ = e.DBF.value;
    ((bwd)localObject1).TfR = com.tencent.mm.plugin.hld.model.d.DBA.value;
    Object localObject2 = n.DEn;
    ((bwd)localObject1).TfS = n.eET();
    localObject2 = (com.tencent.mm.plugin.hld.a.d)h.ae(com.tencent.mm.plugin.hld.a.d.class);
    boolean bool1;
    Object localObject3;
    if ((localObject2 == null) || (((com.tencent.mm.plugin.hld.a.d)localObject2).eCC() != true))
    {
      bool1 = true;
      ((bwd)localObject1).TfT = bool1;
      localObject2 = i.DHq;
      if (i.eGC()) {
        break label373;
      }
      localObject2 = new duw();
      localObject3 = ai.czn();
      if (localObject3 != null)
      {
        ((duw)localObject2).longitude = ((cqh)localObject3).ScO;
        ((duw)localObject2).latitude = ((cqh)localObject3).ScP;
      }
      Log.i("WxIme.CgiImeGetImeDictListConfig", " loc:[" + ((duw)localObject2).longitude + ", " + ((duw)localObject2).latitude + ']');
      ((bwd)localObject1).TfU = ((duw)localObject2);
      ((bwd)localObject1).TfV = true;
      label213:
      if (paramclg != null)
      {
        paramclg = paramclg.TfX;
        if (paramclg != null) {
          ((bwd)localObject1).TfX = paramclg;
        }
      }
      paramclg = new bwe();
      paramclg.setBaseResponse(new jh());
      paramclg.getBaseResponse().Tef = new eaf();
      locala.c((a)localObject1);
      locala.d((a)paramclg);
      if (!bool2) {
        break label382;
      }
      locala.TW("/cgi-bin/mmsprime/getimedictlistconfig");
      locala.vD(4872);
      c(locala.bgN());
    }
    for (;;)
    {
      Log.i("WxIme.CgiImeGetImeDictListConfig", "isLogin:" + bool2 + " is_initializing:" + ((bwd)localObject1).TfT + " engineVersion:" + ((bwd)localObject1).TfS);
      AppMethodBeat.o(216834);
      return;
      bool1 = false;
      break;
      label373:
      ((bwd)localObject1).TfV = false;
      break label213;
      label382:
      locala.TW("/cgi-bin/mmsprime/getimedictlistconfignonlogin");
      locala.vD(5126);
      localObject2 = new ets();
      localObject3 = new eur();
      ((eur)localObject3).Uwn = new eae();
      ((ets)localObject2).UvB = ((eur)localObject3);
      localObject3 = new eto();
      Object localObject4 = locala.bgN();
      p.j(localObject4, "rr");
      localObject4 = ((com.tencent.mm.an.d)localObject4).getReqObj();
      if ((localObject4 instanceof d.b))
      {
        ((d.b)localObject4).toProtoBuf();
        ((eto)localObject3).BaseRequest = ((bwd)localObject1).getBaseRequest();
        ((eto)localObject3).Uvy = z.aN(((bwd)localObject1).toByteArray());
      }
      ((ets)localObject2).UvC = ((eto)localObject3);
      locala.c((a)localObject2);
      locala.d((a)paramclg);
      paramclg = locala.bgN();
      p.j(paramclg, "rr");
      paramclg.getReqObj().setReqPackControl((l.a)new l.a()
      {
        public final boolean a(PByteArray paramAnonymousPByteArray, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(214055);
          Log.i("WxIme.CgiImeGetImeDictListConfig", "reqPackControl");
          paramAnonymousArrayOfByte2 = this.sDH;
          p.j(paramAnonymousArrayOfByte2, "rr");
          paramAnonymousArrayOfByte2 = paramAnonymousArrayOfByte2.getReqObj();
          Object localObject = this.sDH;
          p.j(localObject, "rr");
          localObject = ((com.tencent.mm.an.d)localObject).bhX();
          if (localObject == null)
          {
            paramAnonymousPByteArray = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.TransferEncryptReq");
            AppMethodBeat.o(214055);
            throw paramAnonymousPByteArray;
          }
          localObject = (ets)localObject;
          long l = f.cW(null);
          paramAnonymousArrayOfByte2.setEcdhEngine(l);
          localObject = UtilsJni.HybridEcdhEncrypt(l, ((ets)localObject).toByteArray());
          boolean bool = MMProtocalJni.packHybridEcdh(paramAnonymousPByteArray, paramAnonymousArrayOfByte1, paramAnonymousArrayOfByte2.getDeviceID(), paramAnonymousArrayOfByte2.getUin(), 5126, f.hoP(), (byte[])localObject, paramAnonymousInt2, paramAnonymousInt3, 12);
          Log.i("WxIme.CgiImeGetImeDictListConfig", "summerauths reqToBuf packHybridEcdh using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(f.hoP()), Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(bool) });
          AppMethodBeat.o(214055);
          return true;
        }
      });
      paramclg.bhZ();
      paramclg.getReqObj().setUseECDH(false);
      c(paramclg);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/cgi/CgiImeGetImeDictListConfig$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.b.b
 * JD-Core Version:    0.7.0.1
 */