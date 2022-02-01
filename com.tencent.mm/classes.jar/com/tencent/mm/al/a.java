package com.tencent.mm.al;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static String hSu = "";
  private static long hSv = 0L;
  
  public static void DW(String paramString)
  {
    AppMethodBeat.i(123976);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123976);
      return;
    }
    paramString = ag.aGp().Ef(paramString);
    paramString.field_attrSyncVersion = null;
    paramString.field_incrementUpdateTime = 0L;
    ag.aGp().g(paramString);
    AppMethodBeat.o(123976);
  }
  
  public static void DX(String paramString)
  {
    AppMethodBeat.i(123977);
    hSu = paramString;
    hSv = System.currentTimeMillis();
    AppMethodBeat.o(123977);
  }
  
  public static boolean DY(String paramString)
  {
    AppMethodBeat.i(123978);
    if ((bu.lX(hSu, paramString)) && (System.currentTimeMillis() - hSv < 1000L))
    {
      AppMethodBeat.o(123978);
      return true;
    }
    AppMethodBeat.o(123978);
    return false;
  }
  
  public static boolean a(an paraman, c paramc, List<mw> paramList)
  {
    AppMethodBeat.i(123982);
    if ((paraman == null) || (paramList == null) || (paramList.size() == 0))
    {
      ae.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed.");
      AppMethodBeat.o(123982);
      return false;
    }
    String str1 = paraman.field_username;
    if (!paraman.fug())
    {
      ae.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact is not a biz contact.(username : %s)", new Object[] { str1 });
      AppMethodBeat.o(123982);
      return false;
    }
    c localc = paramc;
    if (paramc == null) {
      localc = ag.aGp().Ef(str1);
    }
    if (localc == null)
    {
      ae.i("MicroMsg.BizAttrRenovator", "BizInfo is null.(username : %s)", new Object[] { str1 });
      AppMethodBeat.o(123982);
      return false;
    }
    i locali = p.aEN().DL(str1);
    long l1;
    int i;
    int k;
    mw localmw;
    try
    {
      if (bu.isNullOrNil(localc.field_extInfo)) {}
      for (paramc = new JSONObject();; paramc = new JSONObject(localc.field_extInfo))
      {
        l1 = -1L;
        l2 = paraman.field_type;
        i = 0;
        paramList = paramList.iterator();
        k = 0;
        for (;;)
        {
          if (!paramList.hasNext()) {
            break label735;
          }
          localmw = (mw)paramList.next();
          if (localmw != null) {
            break;
          }
          ae.w("MicroMsg.BizAttrRenovator", "keyValue is null.");
        }
      }
    }
    catch (Exception paramc)
    {
      String str2;
      for (;;)
      {
        ae.e("MicroMsg.BizAttrRenovator", "create Json object from extInfo error. %s.", new Object[] { paramc });
        paramc = new JSONObject();
        continue;
        str2 = localmw.uuW;
        ae.i("MicroMsg.BizAttrRenovator", "[BizAttr] UpdateInfoList key = %s, value = %s", new Object[] { str2, localmw.yxn });
        String str3 = localmw.yxn;
        if (!"UserName".equals(str2))
        {
          if ("NickName".equals(str2)) {
            paraman.to(str3);
          }
        }
        else
        {
          label312:
          j = 1;
          label315:
          if ((j == 0) && (!a(paramc, str2, localmw.yxn, str1)))
          {
            str3 = localmw.yxn;
            if (!"BrandInfo".equals(str2)) {
              break label502;
            }
            localc.field_brandInfo = str3;
            label360:
            j = 1;
          }
        }
        for (;;)
        {
          if (j == 0) {
            break label595;
          }
          i += 1;
          break;
          if ("Alias".equals(str2))
          {
            paraman.tl(str3);
            break label312;
          }
          if ("PYInitial".equals(str2))
          {
            paraman.tp(str3);
            break label312;
          }
          if ("QuanPin".equals(str2))
          {
            paraman.tq(str3);
            break label312;
          }
          if ("VerifyFlag".equals(str2))
          {
            paraman.kd(bu.getInt(str3, paraman.field_verifyFlag));
            break label312;
          }
          if ("VerifyInfo".equals(str2))
          {
            paraman.tK(str3);
            break label312;
          }
          if ("Signature".equals(str2))
          {
            paraman.tF(str3);
            break label312;
          }
          j = 0;
          break label315;
          label502:
          if ("BrandIconURL".equals(str2))
          {
            localc.field_brandIconURL = str3;
            break label360;
          }
          if ("BrandFlag".equals(str2))
          {
            localc.field_brandFlag = bu.getInt(str3, localc.field_brandFlag);
            break label360;
          }
          if ("Appid".equals(str2))
          {
            if (str3.equals(localc.field_appId))
            {
              j = 0;
              continue;
            }
            localc.field_appId = str3;
            break label360;
          }
          j = 0;
        }
        label595:
        str3 = localmw.yxn;
        if ("BigHeadImgUrl".equals(str2)) {
          if (locali != null) {
            locali.hPQ = str3;
          }
        }
        label625:
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label675;
          }
          i += 1;
          k = 1;
          break;
          if ("SmallHeadImgUrl".equals(str2))
          {
            if (locali == null) {
              break label625;
            }
            locali.hPP = str3;
            break label625;
          }
        }
        label675:
        if (!"BitMask".equals(str2)) {
          break;
        }
        l1 = bu.getLong(localmw.yxn, l1);
        i += 1;
      }
      if (!"BitVal".equals(str2)) {
        break label984;
      }
    }
    long l2 = bu.getLong(localmw.yxn, l2);
    i += 1;
    label984:
    for (;;)
    {
      break;
      label735:
      if (i == 0)
      {
        ae.i("MicroMsg.BizAttrRenovator", "None attribute has been updated.");
        AppMethodBeat.o(123982);
        return false;
      }
      localc.field_extInfo = paramc.toString();
      if ((locali != null) && (k != 0))
      {
        p.aEN().b(locali);
        p.aEA();
        com.tencent.mm.aj.e.L(str1, false);
        p.aEA();
        com.tencent.mm.aj.e.L(str1, true);
        p.aEP().Dw(str1);
        paramc = ag.aGz();
        if (!bu.isNullOrNil(str1))
        {
          ae.d("MicroMsg.BrandLogic", "remove cache by brandKey : %s", new Object[] { str1 });
          paramc = (WeakReference)paramc.hTw.remove(str1);
          if (paramc != null)
          {
            paramc = (Bitmap)paramc.get();
            if (paramc != null) {
              paramc.isRecycled();
            }
          }
        }
      }
      paraman.setType(paraman.field_type | (int)(l1 & l2));
      i = ((l)g.ab(l.class)).azF().c(str1, paraman);
      ag.aGp().g(localc);
      if (i == 1) {
        ((l)g.ab(l.class)).azF().b(4, (n)((l)g.ab(l.class)).azF(), str1);
      }
      ae.i("MicroMsg.BizAttrRenovator", "Update bizInfo attributes successfully.");
      AppMethodBeat.o(123982);
      return true;
    }
  }
  
  private static boolean a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(188868);
    try
    {
      if ("IsShowHeadImgInMsg".equals(paramString1)) {
        paramJSONObject.put(paramString1, paramString2);
      }
      for (;;)
      {
        AppMethodBeat.o(188868);
        return true;
        if (!"IsHideInputToolbarInMsg".equals(paramString1)) {
          break;
        }
        paramJSONObject.put(paramString1, paramString2);
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ae.e("MicroMsg.BizAttrRenovator", "updateExtInfoAttrs failed, key(%s) value(%s), exception : %s.", new Object[] { paramString1, paramString2, paramJSONObject });
        continue;
        if (!"IsAgreeProtocol".equals(paramString1)) {
          if ("InteractiveMode".equals(paramString1)) {
            paramJSONObject.put(paramString1, bu.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("CanReceiveSpeexVoice".equals(paramString1)) {
            paramJSONObject.put(paramString1, paramString2);
          } else if ("ConnectorMsgType".equals(paramString1)) {
            paramJSONObject.put(paramString1, bu.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("ReportLocationType".equals(paramString1)) {
            paramJSONObject.put(paramString1, bu.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("AudioPlayType".equals(paramString1)) {
            paramJSONObject.put(paramString1, bu.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("IsShowMember".equals(paramString1)) {
            paramJSONObject.put(paramString1, paramString2);
          } else if ("ConferenceContactExpireTime".equals(paramString1)) {
            paramJSONObject.put(paramString1, paramString2);
          } else if (!"VerifyMsg2Remark".equals(paramString1)) {
            if ("VerifyContactPromptTitle".equals(paramString1)) {
              paramJSONObject.put(paramString1, paramString2);
            } else if (!"IsSubscribeStat".equals(paramString1)) {
              if ("ScanQRCodeType".equals(paramString1)) {
                paramJSONObject.put(paramString1, bu.getInt(paramString2, paramJSONObject.optInt(paramString1)));
              } else if ("ServiceType".equals(paramString1)) {
                paramJSONObject.put(paramString1, bu.getInt(paramString2, paramJSONObject.optInt(paramString1)));
              } else if (!"NeedShowUserAddrObtaining".equals(paramString1)) {
                if ("SupportEmoticonLinkPrefix".equals(paramString1)) {
                  paramJSONObject.put(paramString1, paramString2);
                } else if ("FunctionFlag".equals(paramString1)) {
                  paramJSONObject.put(paramString1, bu.getInt(paramString2, paramJSONObject.optInt(paramString1)));
                } else if ("NotifyManage".equals(paramString1)) {
                  paramJSONObject.put(paramString1, paramString2);
                } else if ("ServicePhone".equals(paramString1)) {
                  paramJSONObject.put(paramString1, paramString2);
                } else if ("IsTrademarkProtection".equals(paramString1)) {
                  paramJSONObject.put(paramString1, paramString2);
                } else if (!"CanReceiveLongVideo".equals(paramString1)) {
                  if ("TrademarkUrl".equals(paramString1))
                  {
                    paramJSONObject.put(paramString1, paramString2);
                  }
                  else if ("TrademarkName".equals(paramString1))
                  {
                    paramJSONObject.put(paramString1, paramString2);
                  }
                  else if ("MMBizMenu".equals(paramString1))
                  {
                    if (paramString3.equals("gh_f0a92aa7146c"))
                    {
                      ae.i("MicroMsg.BizAttrRenovator", "username.equals(ContactStorageLogic.SPUSER_WXPAY_COLLECTION),dont update MMBizMenu.");
                      AppMethodBeat.o(188868);
                      return true;
                    }
                    paramJSONObject.put(paramString1, paramString2);
                  }
                  else if ("VerifySource".equals(paramString1))
                  {
                    paramJSONObject.put(paramString1, paramString2);
                  }
                  else if ("PersonVerifyInfo".equals(paramString1))
                  {
                    paramJSONObject.put(paramString1, paramString2);
                  }
                  else if (!"MMBizTabbar".equals(paramString1))
                  {
                    if ("PayShowInfo".equals(paramString1)) {
                      paramJSONObject.put(paramString1, paramString2);
                    } else if ("HardwareBizInfo".equals(paramString1)) {
                      paramJSONObject.put(paramString1, paramString2);
                    } else if ("EnterpriseBizInfo".equals(paramString1)) {
                      paramJSONObject.put(paramString1, paramString2);
                    } else if (!"MainPage".equals(paramString1)) {
                      if ("RegisterSource".equals(paramString1)) {
                        paramJSONObject.put(paramString1, paramString2);
                      } else if (!"IBeaconBizInfo".equals(paramString1)) {
                        if ("WxaAppInfo".equals(paramString1))
                        {
                          paramJSONObject.put(paramString1, paramString2);
                        }
                        else if ("WxaAppVersionInfo".equals(paramString1))
                        {
                          paramJSONObject.put(paramString1, paramString2);
                        }
                        else if ("WXAppType".equals(paramString1))
                        {
                          paramJSONObject.put(paramString1, paramString2);
                        }
                        else if ("BindWxaInfo".equals(paramString1))
                        {
                          paramJSONObject.put(paramString1, paramString2);
                        }
                        else
                        {
                          if (!"AcctTransferInfo".equals(paramString1)) {
                            break;
                          }
                          paramJSONObject.put(paramString1, paramString2);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(188868);
    }
    return false;
  }
  
  public static boolean aFH()
  {
    AppMethodBeat.i(123980);
    Object localObject = g.ajR().ajA().get(am.a.IMM, null);
    if ((localObject == null) || (!(localObject instanceof Integer))) {
      ae.i("MicroMsg.BizAttrRenovator", "openFlag is null.");
    }
    for (int i = 1;; i = ((Integer)localObject).intValue())
    {
      ae.i("MicroMsg.BizAttrRenovator", "openFlag is %d.", new Object[] { Integer.valueOf(i) });
      if (i != 1) {
        break;
      }
      AppMethodBeat.o(123980);
      return true;
    }
    AppMethodBeat.o(123980);
    return false;
  }
  
  static boolean d(c paramc)
  {
    AppMethodBeat.i(123979);
    if (paramc == null)
    {
      ae.i("MicroMsg.BizAttrRenovator", "BizInfo is null.");
      AppMethodBeat.o(123979);
      return false;
    }
    if (!aFH())
    {
      AppMethodBeat.o(123979);
      return false;
    }
    int j = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("MMBizAttrSyncFreq", -1);
    int i = j;
    if (j == -1)
    {
      ae.i("MicroMsg.BizAttrRenovator", "MMBizAttrSyncFreq is null.");
      i = 3600;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramc.field_incrementUpdateTime;
    ae.i("MicroMsg.BizAttrRenovator", "currentMS(%d), lastUpdateTime(%d), freq(%d), version(%s).", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), paramc.field_attrSyncVersion });
    if (l1 - l2 >= i * 1000L)
    {
      AppMethodBeat.o(123979);
      return true;
    }
    AppMethodBeat.o(123979);
    return false;
  }
  
  public final boolean DZ(final String paramString)
  {
    AppMethodBeat.i(123981);
    if (bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is null or nil.");
      AppMethodBeat.o(123981);
      return false;
    }
    if (DY(paramString))
    {
      ae.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is just delete.");
      AppMethodBeat.o(123981);
      return false;
    }
    ae.d("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes");
    c localc = ag.aGp().Ef(paramString);
    if (!d(localc))
    {
      ae.i("MicroMsg.BizAttrRenovator", "do not need to update biz attrs now.");
      AppMethodBeat.o(123981);
      return false;
    }
    if (paramString.equals("gh_f0a92aa7146c"))
    {
      ae.i("MicroMsg.BizAttrRenovator", "username == ContactStorageLogic.SPUSER_WXPAY_COLLECTION，go NetScene Plugin");
      g.ajQ().gDv.a(new aa(new aa.a() {}), 0);
    }
    final WeakReference localWeakReference = new WeakReference(null);
    g.ajQ().gDv.a(new u(paramString, localc.field_attrSyncVersion, new u.a() {}), 0);
    AppMethodBeat.o(123981);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a
 * JD-Core Version:    0.7.0.1
 */