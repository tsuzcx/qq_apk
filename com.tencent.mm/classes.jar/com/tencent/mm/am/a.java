package com.tencent.mm.am;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.q;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.ly;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bg;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static String gWL = "";
  private static long gWM = 0L;
  
  public static boolean a(com.tencent.mm.storage.af paramaf, c paramc, List<ly> paramList)
  {
    AppMethodBeat.i(123982);
    if ((paramaf == null) || (paramList == null) || (paramList.size() == 0))
    {
      ad.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed.");
      AppMethodBeat.o(123982);
      return false;
    }
    String str1 = paramaf.field_username;
    if (!paramaf.eKB())
    {
      ad.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact is not a biz contact.(username : %s)", new Object[] { str1 });
      AppMethodBeat.o(123982);
      return false;
    }
    c localc = paramc;
    if (paramc == null) {
      localc = af.awe().wy(str1);
    }
    if (localc == null)
    {
      ad.i("MicroMsg.BizAttrRenovator", "BizInfo is null.(username : %s)", new Object[] { str1 });
      AppMethodBeat.o(123982);
      return false;
    }
    i locali = p.auF().we(str1);
    long l1;
    int i;
    int k;
    ly locally;
    try
    {
      if (bt.isNullOrNil(localc.field_extInfo)) {}
      for (paramc = new JSONObject();; paramc = new JSONObject(localc.field_extInfo))
      {
        l1 = -1L;
        l2 = paramaf.field_type;
        i = 0;
        paramList = paramList.iterator();
        k = 0;
        for (;;)
        {
          if (!paramList.hasNext()) {
            break label731;
          }
          locally = (ly)paramList.next();
          if (locally != null) {
            break;
          }
          ad.w("MicroMsg.BizAttrRenovator", "keyValue is null.");
        }
      }
    }
    catch (Exception paramc)
    {
      String str2;
      for (;;)
      {
        ad.e("MicroMsg.BizAttrRenovator", "create Json object from extInfo error. %s.", new Object[] { paramc });
        paramc = new JSONObject();
        continue;
        str2 = locally.sdv;
        ad.i("MicroMsg.BizAttrRenovator", "[BizAttr] UpdateInfoList key = %s, value = %s", new Object[] { str2, locally.vJI });
        String str3 = locally.vJI;
        if (!"UserName".equals(str2))
        {
          if ("NickName".equals(str2)) {
            paramaf.nd(str3);
          }
        }
        else
        {
          label312:
          j = 1;
          label315:
          if ((j == 0) && (!a(paramc, str2, locally.vJI, str1)))
          {
            str3 = locally.vJI;
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
            paramaf.na(str3);
            break label312;
          }
          if ("PYInitial".equals(str2))
          {
            paramaf.ne(str3);
            break label312;
          }
          if ("QuanPin".equals(str2))
          {
            paramaf.nf(str3);
            break label312;
          }
          if ("VerifyFlag".equals(str2))
          {
            paramaf.jF(bt.getInt(str3, paramaf.field_verifyFlag));
            break label312;
          }
          if ("VerifyInfo".equals(str2))
          {
            paramaf.nz(str3);
            break label312;
          }
          if ("Signature".equals(str2))
          {
            paramaf.nu(str3);
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
            localc.field_brandFlag = bt.getInt(str3, localc.field_brandFlag);
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
        str3 = locally.vJI;
        if ("BigHeadImgUrl".equals(str2)) {
          if (locali != null) {
            locali.gUg = str3;
          }
        }
        label624:
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label673;
          }
          i += 1;
          k = 1;
          break;
          if ("SmallHeadImgUrl".equals(str2))
          {
            if (locali == null) {
              break label624;
            }
            locali.gUf = str3;
            break label624;
          }
        }
        label673:
        if (!"BitMask".equals(str2)) {
          break;
        }
        l1 = bt.getLong(locally.vJI, l1);
        i += 1;
      }
      if (!"BitVal".equals(str2)) {
        break label979;
      }
    }
    long l2 = bt.getLong(locally.vJI, l2);
    i += 1;
    label979:
    for (;;)
    {
      break;
      label731:
      if (i == 0)
      {
        ad.i("MicroMsg.BizAttrRenovator", "None attribute has been updated.");
        AppMethodBeat.o(123982);
        return false;
      }
      localc.field_extInfo = paramc.toString();
      if ((locali != null) && (k != 0))
      {
        p.auF().b(locali);
        p.auq();
        com.tencent.mm.ak.e.K(str1, false);
        p.auq();
        com.tencent.mm.ak.e.K(str1, true);
        p.auH().vP(str1);
        paramc = af.awo();
        if (!bt.isNullOrNil(str1))
        {
          ad.d("MicroMsg.BrandLogic", "remove cache by brandKey : %s", new Object[] { str1 });
          paramc = (WeakReference)paramc.gXL.remove(str1);
          if (paramc != null)
          {
            paramc = (Bitmap)paramc.get();
            if (paramc != null) {
              paramc.isRecycled();
            }
          }
        }
      }
      paramaf.setType(paramaf.field_type | (int)(l1 & l2));
      i = ((k)g.ab(k.class)).apM().c(str1, paramaf);
      af.awe().g(localc);
      if (i == 1) {
        ((k)g.ab(k.class)).apM().b(4, (n)((k)g.ab(k.class)).apM(), str1);
      }
      ad.i("MicroMsg.BizAttrRenovator", "Update bizInfo attributes successfully.");
      AppMethodBeat.o(123982);
      return true;
    }
  }
  
  private static boolean a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(191044);
    try
    {
      if ("IsShowHeadImgInMsg".equals(paramString1)) {
        paramJSONObject.put(paramString1, paramString2);
      }
      for (;;)
      {
        AppMethodBeat.o(191044);
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
        ad.e("MicroMsg.BizAttrRenovator", "updateExtInfoAttrs failed, key(%s) value(%s), exception : %s.", new Object[] { paramString1, paramString2, paramJSONObject });
        continue;
        if (!"IsAgreeProtocol".equals(paramString1)) {
          if ("InteractiveMode".equals(paramString1)) {
            paramJSONObject.put(paramString1, bt.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("CanReceiveSpeexVoice".equals(paramString1)) {
            paramJSONObject.put(paramString1, paramString2);
          } else if ("ConnectorMsgType".equals(paramString1)) {
            paramJSONObject.put(paramString1, bt.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("ReportLocationType".equals(paramString1)) {
            paramJSONObject.put(paramString1, bt.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("AudioPlayType".equals(paramString1)) {
            paramJSONObject.put(paramString1, bt.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("IsShowMember".equals(paramString1)) {
            paramJSONObject.put(paramString1, paramString2);
          } else if ("ConferenceContactExpireTime".equals(paramString1)) {
            paramJSONObject.put(paramString1, paramString2);
          } else if (!"VerifyMsg2Remark".equals(paramString1)) {
            if ("VerifyContactPromptTitle".equals(paramString1)) {
              paramJSONObject.put(paramString1, paramString2);
            } else if (!"IsSubscribeStat".equals(paramString1)) {
              if ("ScanQRCodeType".equals(paramString1)) {
                paramJSONObject.put(paramString1, bt.getInt(paramString2, paramJSONObject.optInt(paramString1)));
              } else if ("ServiceType".equals(paramString1)) {
                paramJSONObject.put(paramString1, bt.getInt(paramString2, paramJSONObject.optInt(paramString1)));
              } else if (!"NeedShowUserAddrObtaining".equals(paramString1)) {
                if ("SupportEmoticonLinkPrefix".equals(paramString1)) {
                  paramJSONObject.put(paramString1, paramString2);
                } else if ("FunctionFlag".equals(paramString1)) {
                  paramJSONObject.put(paramString1, bt.getInt(paramString2, paramJSONObject.optInt(paramString1)));
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
                      ad.i("MicroMsg.BizAttrRenovator", "username.equals(ContactStorageLogic.SPUSER_WXPAY_COLLECTION),dont update MMBizMenu.");
                      AppMethodBeat.o(191044);
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
      AppMethodBeat.o(191044);
    }
    return false;
  }
  
  public static boolean avv()
  {
    AppMethodBeat.i(123980);
    Object localObject = g.afB().afk().get(ae.a.Fij, null);
    if ((localObject == null) || (!(localObject instanceof Integer))) {
      ad.i("MicroMsg.BizAttrRenovator", "openFlag is null.");
    }
    for (int i = 1;; i = ((Integer)localObject).intValue())
    {
      ad.i("MicroMsg.BizAttrRenovator", "openFlag is %d.", new Object[] { Integer.valueOf(i) });
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
      ad.i("MicroMsg.BizAttrRenovator", "BizInfo is null.");
      AppMethodBeat.o(123979);
      return false;
    }
    if (!avv())
    {
      AppMethodBeat.o(123979);
      return false;
    }
    int j = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("MMBizAttrSyncFreq", -1);
    int i = j;
    if (j == -1)
    {
      ad.i("MicroMsg.BizAttrRenovator", "MMBizAttrSyncFreq is null.");
      i = 3600;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramc.field_incrementUpdateTime;
    ad.i("MicroMsg.BizAttrRenovator", "currentMS(%d), lastUpdateTime(%d), freq(%d), version(%s).", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), paramc.field_attrSyncVersion });
    if (l1 - l2 >= i * 1000L)
    {
      AppMethodBeat.o(123979);
      return true;
    }
    AppMethodBeat.o(123979);
    return false;
  }
  
  public static void wp(String paramString)
  {
    AppMethodBeat.i(123976);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123976);
      return;
    }
    paramString = af.awe().wy(paramString);
    paramString.field_attrSyncVersion = null;
    paramString.field_incrementUpdateTime = 0L;
    af.awe().g(paramString);
    AppMethodBeat.o(123976);
  }
  
  public static void wq(String paramString)
  {
    AppMethodBeat.i(123977);
    gWL = paramString;
    gWM = System.currentTimeMillis();
    AppMethodBeat.o(123977);
  }
  
  public static boolean wr(String paramString)
  {
    AppMethodBeat.i(123978);
    if ((bt.kU(gWL, paramString)) && (System.currentTimeMillis() - gWM < 1000L))
    {
      AppMethodBeat.o(123978);
      return true;
    }
    AppMethodBeat.o(123978);
    return false;
  }
  
  public final boolean ws(final String paramString)
  {
    AppMethodBeat.i(123981);
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is null or nil.");
      AppMethodBeat.o(123981);
      return false;
    }
    if (wr(paramString))
    {
      ad.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is just delete.");
      AppMethodBeat.o(123981);
      return false;
    }
    ad.d("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes");
    c localc = af.awe().wy(paramString);
    if (!d(localc))
    {
      ad.i("MicroMsg.BizAttrRenovator", "do not need to update biz attrs now.");
      AppMethodBeat.o(123981);
      return false;
    }
    if (paramString.equals("gh_f0a92aa7146c"))
    {
      ad.i("MicroMsg.BizAttrRenovator", "username == ContactStorageLogic.SPUSER_WXPAY_COLLECTION，go NetScene Plugin");
      g.afA().gcy.a(new z(new z.a() {}), 0);
    }
    final WeakReference localWeakReference = new WeakReference(null);
    g.afA().gcy.a(new t(paramString, localc.field_attrSyncVersion, new t.a() {}), 0);
    AppMethodBeat.o(123981);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a
 * JD-Core Version:    0.7.0.1
 */