package com.tencent.mm.ai;

import android.graphics.Bitmap;
import com.tencent.mm.ag.c;
import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.in;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private static String eeE = "";
  private static long eeF = 0L;
  
  public static boolean Lp()
  {
    Object localObject = g.DP().Dz().get(ac.a.upO, null);
    if ((localObject == null) || (!(localObject instanceof Integer))) {
      y.i("MicroMsg.BizAttrRenovator", "openFlag is null.");
    }
    for (int i = 1;; i = ((Integer)localObject).intValue())
    {
      y.i("MicroMsg.BizAttrRenovator", "openFlag is %d.", new Object[] { Integer.valueOf(i) });
      if (i != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(ad paramad, d paramd, List<in> paramList)
  {
    if ((paramad == null) || (paramList == null) || (paramList.size() == 0))
    {
      y.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed.");
      return false;
    }
    String str1 = paramad.field_username;
    if (!paramad.cua())
    {
      y.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact is not a biz contact.(username : %s)", new Object[] { str1 });
      return false;
    }
    d locald = paramd;
    if (paramd == null) {
      locald = z.My().kQ(str1);
    }
    if (locald == null)
    {
      y.i("MicroMsg.BizAttrRenovator", "BizInfo is null.(username : %s)", new Object[] { str1 });
      return false;
    }
    h localh = o.Kh().kp(str1);
    long l1;
    int i;
    int k;
    in localin;
    try
    {
      if (bk.bl(locald.field_extInfo)) {}
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
            break label713;
          }
          localin = (in)paramList.next();
          if (localin != null) {
            break;
          }
          y.w("MicroMsg.BizAttrRenovator", "keyValue is null.");
        }
      }
    }
    catch (Exception paramd)
    {
      String str2;
      for (;;)
      {
        y.e("MicroMsg.BizAttrRenovator", "create Json object from extInfo error. %s.", new Object[] { paramd });
        paramd = new JSONObject();
        continue;
        str2 = localin.sCH;
        y.i("MicroMsg.BizAttrRenovator", "[BizAttr] UpdateInfoList key = %s, value = %s", new Object[] { str2, localin.nFs });
        String str3 = localin.nFs;
        if (!"UserName".equals(str2))
        {
          if ("NickName".equals(str2)) {
            paramad.dk(str3);
          }
        }
        else
        {
          label292:
          j = 1;
          label295:
          if ((j == 0) && (!b(paramd, str2, localin.nFs)))
          {
            str3 = localin.nFs;
            if (!"BrandInfo".equals(str2)) {
              break label480;
            }
            locald.field_brandInfo = str3;
            label338:
            j = 1;
          }
        }
        for (;;)
        {
          if (j == 0) {
            break label573;
          }
          i += 1;
          break;
          if ("Alias".equals(str2))
          {
            paramad.cZ(str3);
            break label292;
          }
          if ("PYInitial".equals(str2))
          {
            paramad.dl(str3);
            break label292;
          }
          if ("QuanPin".equals(str2))
          {
            paramad.dm(str3);
            break label292;
          }
          if ("VerifyFlag".equals(str2))
          {
            paramad.fi(bk.getInt(str3, paramad.field_verifyFlag));
            break label292;
          }
          if ("VerifyInfo".equals(str2))
          {
            paramad.dE(str3);
            break label292;
          }
          if ("Signature".equals(str2))
          {
            paramad.dz(str3);
            break label292;
          }
          j = 0;
          break label295;
          label480:
          if ("BrandIconURL".equals(str2))
          {
            locald.field_brandIconURL = str3;
            break label338;
          }
          if ("BrandFlag".equals(str2))
          {
            locald.field_brandFlag = bk.getInt(str3, locald.field_brandFlag);
            break label338;
          }
          if ("Appid".equals(str2))
          {
            if (str3.equals(locald.field_appId))
            {
              j = 0;
              continue;
            }
            locald.field_appId = str3;
            break label338;
          }
          j = 0;
        }
        label573:
        str3 = localin.nFs;
        if ("BigHeadImgUrl".equals(str2)) {
          if (localh != null) {
            localh.ebT = str3;
          }
        }
        label603:
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label653;
          }
          i += 1;
          k = 1;
          break;
          if ("SmallHeadImgUrl".equals(str2))
          {
            if (localh == null) {
              break label603;
            }
            localh.ebS = str3;
            break label603;
          }
        }
        label653:
        if (!"BitMask".equals(str2)) {
          break;
        }
        l1 = bk.getLong(localin.nFs, l1);
        i += 1;
      }
      if (!"BitVal".equals(str2)) {
        break label908;
      }
    }
    long l2 = bk.getLong(localin.nFs, l2);
    i += 1;
    label908:
    for (;;)
    {
      break;
      label713:
      if (i == 0)
      {
        y.i("MicroMsg.BizAttrRenovator", "None attribute has been updated.");
        return false;
      }
      locald.field_extInfo = paramd.toString();
      if ((localh != null) && (k != 0))
      {
        o.Kh().a(localh);
        o.JQ();
        com.tencent.mm.ag.d.B(str1, false);
        o.JQ();
        com.tencent.mm.ag.d.B(str1, true);
        o.Kj().kb(str1);
        paramd = z.MI();
        if (!bk.bl(str1))
        {
          y.d("MicroMsg.BrandLogic", "remove cache by brandKey : %s", new Object[] { str1 });
          paramd = (WeakReference)paramd.egG.remove(str1);
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
      ((j)g.r(j.class)).Fw().a(str1, paramad);
      z.My().e(locald);
      y.i("MicroMsg.BizAttrRenovator", "Update bizInfo attributes successfully.");
      return true;
    }
  }
  
  static boolean b(d paramd)
  {
    if (paramd == null)
    {
      y.i("MicroMsg.BizAttrRenovator", "BizInfo is null.");
      return false;
    }
    if (!Lp()) {
      return false;
    }
    int j = ((com.tencent.mm.plugin.zero.b.a)g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getInt("MMBizAttrSyncFreq", -1);
    int i = j;
    if (j == -1)
    {
      y.i("MicroMsg.BizAttrRenovator", "MMBizAttrSyncFreq is null.");
      i = 3600;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramd.field_incrementUpdateTime;
    y.i("MicroMsg.BizAttrRenovator", "currentMS(%d), lastUpdateTime(%d), freq(%d), version(%s).", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), paramd.field_attrSyncVersion });
    return l1 - l2 >= i * 1000L;
  }
  
  private static boolean b(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    boolean bool = false;
    try
    {
      if ("IsShowHeadImgInMsg".equals(paramString1)) {
        paramJSONObject.put(paramString1, paramString2);
      } else if ("IsHideInputToolbarInMsg".equals(paramString1)) {
        paramJSONObject.put(paramString1, paramString2);
      }
    }
    catch (JSONException paramJSONObject)
    {
      y.e("MicroMsg.BizAttrRenovator", "updateExtInfoAttrs failed, key(%s) value(%s), exception : %s.", new Object[] { paramString1, paramString2, paramJSONObject });
    }
    if (!"IsAgreeProtocol".equals(paramString1)) {
      if ("InteractiveMode".equals(paramString1)) {
        paramJSONObject.put(paramString1, bk.getInt(paramString2, paramJSONObject.optInt(paramString1)));
      } else if ("CanReceiveSpeexVoice".equals(paramString1)) {
        paramJSONObject.put(paramString1, paramString2);
      } else if ("ConnectorMsgType".equals(paramString1)) {
        paramJSONObject.put(paramString1, bk.getInt(paramString2, paramJSONObject.optInt(paramString1)));
      } else if ("ReportLocationType".equals(paramString1)) {
        paramJSONObject.put(paramString1, bk.getInt(paramString2, paramJSONObject.optInt(paramString1)));
      } else if ("AudioPlayType".equals(paramString1)) {
        paramJSONObject.put(paramString1, bk.getInt(paramString2, paramJSONObject.optInt(paramString1)));
      } else if ("IsShowMember".equals(paramString1)) {
        paramJSONObject.put(paramString1, paramString2);
      } else if ("ConferenceContactExpireTime".equals(paramString1)) {
        paramJSONObject.put(paramString1, paramString2);
      } else if (!"VerifyMsg2Remark".equals(paramString1)) {
        if ("VerifyContactPromptTitle".equals(paramString1)) {
          paramJSONObject.put(paramString1, paramString2);
        } else if (!"IsSubscribeStat".equals(paramString1)) {
          if ("ScanQRCodeType".equals(paramString1)) {
            paramJSONObject.put(paramString1, bk.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("ServiceType".equals(paramString1)) {
            paramJSONObject.put(paramString1, bk.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if (!"NeedShowUserAddrObtaining".equals(paramString1)) {
            if ("SupportEmoticonLinkPrefix".equals(paramString1)) {
              paramJSONObject.put(paramString1, paramString2);
            } else if ("FunctionFlag".equals(paramString1)) {
              paramJSONObject.put(paramString1, bk.getInt(paramString2, paramJSONObject.optInt(paramString1)));
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
                        return bool;
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
    bool = true;
    return bool;
  }
  
  public static void kA(String paramString)
  {
    eeE = paramString;
    eeF = System.currentTimeMillis();
  }
  
  public static boolean kB(String paramString)
  {
    return (bk.isEqual(eeE, paramString)) && (System.currentTimeMillis() - eeF < 1000L);
  }
  
  public static void kz(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    paramString = z.My().kQ(paramString);
    paramString.field_attrSyncVersion = null;
    paramString.field_incrementUpdateTime = 0L;
    z.My().e(paramString);
  }
  
  public final boolean kC(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is null or nil.");
      return false;
    }
    if (kB(paramString))
    {
      y.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is just delete.");
      return false;
    }
    y.d("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes");
    d locald = z.My().kQ(paramString);
    if (!b(locald))
    {
      y.i("MicroMsg.BizAttrRenovator", "do not need to update biz attrs now.");
      return false;
    }
    WeakReference localWeakReference = new WeakReference(null);
    g.DO().dJT.a(new p(paramString, locald.field_attrSyncVersion, new a.1(this, paramString, localWeakReference)), 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ai.a
 * JD-Core Version:    0.7.0.1
 */