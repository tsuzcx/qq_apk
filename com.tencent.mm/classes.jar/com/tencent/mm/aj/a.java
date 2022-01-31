package com.tencent.mm.aj;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.c;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.kk;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static String fuG = "";
  private static long fuH = 0L;
  
  public static boolean a(ad paramad, d paramd, List<kk> paramList)
  {
    AppMethodBeat.i(11247);
    if ((paramad == null) || (paramList == null) || (paramList.size() == 0))
    {
      ab.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed.");
      AppMethodBeat.o(11247);
      return false;
    }
    String str1 = paramad.field_username;
    if (!paramad.dwz())
    {
      ab.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact is not a biz contact.(username : %s)", new Object[] { str1 });
      AppMethodBeat.o(11247);
      return false;
    }
    d locald = paramd;
    if (paramd == null) {
      locald = z.afi().rK(str1);
    }
    if (locald == null)
    {
      ab.i("MicroMsg.BizAttrRenovator", "BizInfo is null.(username : %s)", new Object[] { str1 });
      AppMethodBeat.o(11247);
      return false;
    }
    h localh = o.adg().rj(str1);
    long l1;
    int i;
    int k;
    kk localkk;
    try
    {
      if (bo.isNullOrNil(locald.field_extInfo)) {}
      for (paramd = new JSONObject();; paramd = new JSONObject(locald.field_extInfo))
      {
        l1 = -1L;
        l2 = paramad.field_type;
        i = 0;
        paramList = paramList.iterator();
        k = 0;
        for (;;)
        {
          if (!paramList.hasNext()) {
            break label733;
          }
          localkk = (kk)paramList.next();
          if (localkk != null) {
            break;
          }
          ab.w("MicroMsg.BizAttrRenovator", "keyValue is null.");
        }
      }
    }
    catch (Exception paramd)
    {
      String str2;
      for (;;)
      {
        ab.e("MicroMsg.BizAttrRenovator", "create Json object from extInfo error. %s.", new Object[] { paramd });
        paramd = new JSONObject();
        continue;
        str2 = localkk.wxP;
        ab.i("MicroMsg.BizAttrRenovator", "[BizAttr] UpdateInfoList key = %s, value = %s", new Object[] { str2, localkk.qsu });
        String str3 = localkk.qsu;
        if (!"UserName".equals(str2))
        {
          if ("NickName".equals(str2)) {
            paramad.jp(str3);
          }
        }
        else
        {
          label316:
          j = 1;
          label319:
          if ((j == 0) && (!b(paramd, str2, localkk.qsu)))
          {
            str3 = localkk.qsu;
            if (!"BrandInfo".equals(str2)) {
              break label504;
            }
            locald.field_brandInfo = str3;
            label362:
            j = 1;
          }
        }
        for (;;)
        {
          if (j == 0) {
            break label597;
          }
          i += 1;
          break;
          if ("Alias".equals(str2))
          {
            paramad.jm(str3);
            break label316;
          }
          if ("PYInitial".equals(str2))
          {
            paramad.jq(str3);
            break label316;
          }
          if ("QuanPin".equals(str2))
          {
            paramad.jr(str3);
            break label316;
          }
          if ("VerifyFlag".equals(str2))
          {
            paramad.hu(bo.getInt(str3, paramad.field_verifyFlag));
            break label316;
          }
          if ("VerifyInfo".equals(str2))
          {
            paramad.jK(str3);
            break label316;
          }
          if ("Signature".equals(str2))
          {
            paramad.jF(str3);
            break label316;
          }
          j = 0;
          break label319;
          label504:
          if ("BrandIconURL".equals(str2))
          {
            locald.field_brandIconURL = str3;
            break label362;
          }
          if ("BrandFlag".equals(str2))
          {
            locald.field_brandFlag = bo.getInt(str3, locald.field_brandFlag);
            break label362;
          }
          if ("Appid".equals(str2))
          {
            if (str3.equals(locald.field_appId))
            {
              j = 0;
              continue;
            }
            locald.field_appId = str3;
            break label362;
          }
          j = 0;
        }
        label597:
        str3 = localkk.qsu;
        if ("BigHeadImgUrl".equals(str2)) {
          if (localh != null) {
            localh.fsl = str3;
          }
        }
        label626:
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
            if (localh == null) {
              break label626;
            }
            localh.fsk = str3;
            break label626;
          }
        }
        label675:
        if (!"BitMask".equals(str2)) {
          break;
        }
        l1 = bo.getLong(localkk.qsu, l1);
        i += 1;
      }
      if (!"BitVal".equals(str2)) {
        break label983;
      }
    }
    long l2 = bo.getLong(localkk.qsu, l2);
    i += 1;
    label983:
    for (;;)
    {
      break;
      label733:
      if (i == 0)
      {
        ab.i("MicroMsg.BizAttrRenovator", "None attribute has been updated.");
        AppMethodBeat.o(11247);
        return false;
      }
      locald.field_extInfo = paramd.toString();
      if ((localh != null) && (k != 0))
      {
        o.adg().b(localh);
        o.acQ();
        com.tencent.mm.ah.d.F(str1, false);
        o.acQ();
        com.tencent.mm.ah.d.F(str1, true);
        o.adi().qU(str1);
        paramd = z.afs();
        if (!bo.isNullOrNil(str1))
        {
          ab.d("MicroMsg.BrandLogic", "remove cache by brandKey : %s", new Object[] { str1 });
          paramd = (WeakReference)paramd.fwK.remove(str1);
          if (paramd != null)
          {
            paramd = (Bitmap)paramd.get();
            if (paramd != null) {
              paramd.isRecycled();
            }
          }
        }
      }
      paramad.setType(paramad.field_type | (int)(l1 & l2));
      i = ((j)g.E(j.class)).YA().b(str1, paramad);
      z.afi().e(locald);
      if (i == 1) {
        ((j)g.E(j.class)).YA().b(4, (n)((j)g.E(j.class)).YA(), str1);
      }
      ab.i("MicroMsg.BizAttrRenovator", "Update bizInfo attributes successfully.");
      AppMethodBeat.o(11247);
      return true;
    }
  }
  
  public static boolean adX()
  {
    AppMethodBeat.i(11245);
    Object localObject = g.RL().Ru().get(ac.a.yzO, null);
    if ((localObject == null) || (!(localObject instanceof Integer))) {
      ab.i("MicroMsg.BizAttrRenovator", "openFlag is null.");
    }
    for (int i = 1;; i = ((Integer)localObject).intValue())
    {
      ab.i("MicroMsg.BizAttrRenovator", "openFlag is %d.", new Object[] { Integer.valueOf(i) });
      if (i != 1) {
        break;
      }
      AppMethodBeat.o(11245);
      return true;
    }
    AppMethodBeat.o(11245);
    return false;
  }
  
  static boolean b(d paramd)
  {
    AppMethodBeat.i(11244);
    if (paramd == null)
    {
      ab.i("MicroMsg.BizAttrRenovator", "BizInfo is null.");
      AppMethodBeat.o(11244);
      return false;
    }
    if (!adX())
    {
      AppMethodBeat.o(11244);
      return false;
    }
    int j = ((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getInt("MMBizAttrSyncFreq", -1);
    int i = j;
    if (j == -1)
    {
      ab.i("MicroMsg.BizAttrRenovator", "MMBizAttrSyncFreq is null.");
      i = 3600;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramd.field_incrementUpdateTime;
    ab.i("MicroMsg.BizAttrRenovator", "currentMS(%d), lastUpdateTime(%d), freq(%d), version(%s).", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), paramd.field_attrSyncVersion });
    if (l1 - l2 >= i * 1000L)
    {
      AppMethodBeat.o(11244);
      return true;
    }
    AppMethodBeat.o(11244);
    return false;
  }
  
  private static boolean b(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(11248);
    try
    {
      if ("IsShowHeadImgInMsg".equals(paramString1)) {
        paramJSONObject.put(paramString1, paramString2);
      }
      for (;;)
      {
        AppMethodBeat.o(11248);
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
        ab.e("MicroMsg.BizAttrRenovator", "updateExtInfoAttrs failed, key(%s) value(%s), exception : %s.", new Object[] { paramString1, paramString2, paramJSONObject });
        continue;
        if (!"IsAgreeProtocol".equals(paramString1)) {
          if ("InteractiveMode".equals(paramString1)) {
            paramJSONObject.put(paramString1, bo.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("CanReceiveSpeexVoice".equals(paramString1)) {
            paramJSONObject.put(paramString1, paramString2);
          } else if ("ConnectorMsgType".equals(paramString1)) {
            paramJSONObject.put(paramString1, bo.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("ReportLocationType".equals(paramString1)) {
            paramJSONObject.put(paramString1, bo.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("AudioPlayType".equals(paramString1)) {
            paramJSONObject.put(paramString1, bo.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("IsShowMember".equals(paramString1)) {
            paramJSONObject.put(paramString1, paramString2);
          } else if ("ConferenceContactExpireTime".equals(paramString1)) {
            paramJSONObject.put(paramString1, paramString2);
          } else if (!"VerifyMsg2Remark".equals(paramString1)) {
            if ("VerifyContactPromptTitle".equals(paramString1)) {
              paramJSONObject.put(paramString1, paramString2);
            } else if (!"IsSubscribeStat".equals(paramString1)) {
              if ("ScanQRCodeType".equals(paramString1)) {
                paramJSONObject.put(paramString1, bo.getInt(paramString2, paramJSONObject.optInt(paramString1)));
              } else if ("ServiceType".equals(paramString1)) {
                paramJSONObject.put(paramString1, bo.getInt(paramString2, paramJSONObject.optInt(paramString1)));
              } else if (!"NeedShowUserAddrObtaining".equals(paramString1)) {
                if ("SupportEmoticonLinkPrefix".equals(paramString1)) {
                  paramJSONObject.put(paramString1, paramString2);
                } else if ("FunctionFlag".equals(paramString1)) {
                  paramJSONObject.put(paramString1, bo.getInt(paramString2, paramJSONObject.optInt(paramString1)));
                } else if ("NotifyManage".equals(paramString1)) {
                  paramJSONObject.put(paramString1, paramString2);
                } else if ("ServicePhone".equals(paramString1)) {
                  paramJSONObject.put(paramString1, paramString2);
                } else if ("IsTrademarkProtection".equals(paramString1)) {
                  paramJSONObject.put(paramString1, paramString2);
                } else if (!"CanReceiveLongVideo".equals(paramString1)) {
                  if ("TrademarkUrl".equals(paramString1)) {
                    paramJSONObject.put(paramString1, paramString2);
                  } else if ("TrademarkName".equals(paramString1)) {
                    paramJSONObject.put(paramString1, paramString2);
                  } else if ("MMBizMenu".equals(paramString1)) {
                    paramJSONObject.put(paramString1, paramString2);
                  } else if ("VerifySource".equals(paramString1)) {
                    paramJSONObject.put(paramString1, paramString2);
                  } else if (!"MMBizTabbar".equals(paramString1)) {
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
      AppMethodBeat.o(11248);
    }
    return false;
  }
  
  public static void rt(String paramString)
  {
    AppMethodBeat.i(11241);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(11241);
      return;
    }
    paramString = z.afi().rK(paramString);
    paramString.field_attrSyncVersion = null;
    paramString.field_incrementUpdateTime = 0L;
    z.afi().e(paramString);
    AppMethodBeat.o(11241);
  }
  
  public static void ru(String paramString)
  {
    AppMethodBeat.i(11242);
    fuG = paramString;
    fuH = System.currentTimeMillis();
    AppMethodBeat.o(11242);
  }
  
  public static boolean rv(String paramString)
  {
    AppMethodBeat.i(11243);
    if ((bo.isEqual(fuG, paramString)) && (System.currentTimeMillis() - fuH < 1000L))
    {
      AppMethodBeat.o(11243);
      return true;
    }
    AppMethodBeat.o(11243);
    return false;
  }
  
  public final boolean rw(String paramString)
  {
    AppMethodBeat.i(11246);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is null or nil.");
      AppMethodBeat.o(11246);
      return false;
    }
    if (rv(paramString))
    {
      ab.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is just delete.");
      AppMethodBeat.o(11246);
      return false;
    }
    ab.d("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes");
    d locald = z.afi().rK(paramString);
    if (!b(locald))
    {
      ab.i("MicroMsg.BizAttrRenovator", "do not need to update biz attrs now.");
      AppMethodBeat.o(11246);
      return false;
    }
    WeakReference localWeakReference = new WeakReference(null);
    g.RK().eHt.a(new p(paramString, locald.field_attrSyncVersion, new a.1(this, paramString, localWeakReference)), 0);
    AppMethodBeat.o(11246);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aj.a
 * JD-Core Version:    0.7.0.1
 */