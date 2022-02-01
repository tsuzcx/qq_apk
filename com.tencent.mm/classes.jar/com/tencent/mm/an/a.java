package com.tencent.mm.an;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.e;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static String ovF = "";
  private static long ovG = 0L;
  
  public static void Mf(String paramString)
  {
    AppMethodBeat.i(123977);
    ovF = paramString;
    ovG = System.currentTimeMillis();
    AppMethodBeat.o(123977);
  }
  
  public static boolean Mg(String paramString)
  {
    AppMethodBeat.i(123978);
    if ((Util.isEqual(ovF, paramString)) && (System.currentTimeMillis() - ovG < 1000L))
    {
      AppMethodBeat.o(123978);
      return true;
    }
    AppMethodBeat.o(123978);
    return false;
  }
  
  public static boolean a(au paramau, com.tencent.mm.api.c paramc, List<oj> paramList)
  {
    AppMethodBeat.i(123982);
    if ((paramau == null) || (paramList == null) || (paramList.size() == 0))
    {
      Log.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed.");
      AppMethodBeat.o(123982);
      return false;
    }
    String str1 = paramau.field_username;
    if (!paramau.iZC())
    {
      Log.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact is not a biz contact.(username : %s)", new Object[] { str1 });
      AppMethodBeat.o(123982);
      return false;
    }
    com.tencent.mm.api.c localc = paramc;
    if (paramc == null) {
      localc = af.bHf().Mn(str1);
    }
    if (localc == null)
    {
      Log.i("MicroMsg.BizAttrRenovator", "BizInfo is null.(username : %s)", new Object[] { str1 });
      AppMethodBeat.o(123982);
      return false;
    }
    j localj = q.bFE().LS(str1);
    long l1;
    int i;
    int k;
    oj localoj;
    try
    {
      if (Util.isNullOrNil(localc.field_extInfo)) {}
      for (paramc = new JSONObject();; paramc = new JSONObject(localc.field_extInfo))
      {
        l1 = -1L;
        l2 = paramau.field_type;
        i = 0;
        paramList = paramList.iterator();
        k = 0;
        for (;;)
        {
          if (!paramList.hasNext()) {
            break label732;
          }
          localoj = (oj)paramList.next();
          if (localoj != null) {
            break;
          }
          Log.w("MicroMsg.BizAttrRenovator", "keyValue is null.");
        }
      }
    }
    catch (Exception paramc)
    {
      String str2;
      for (;;)
      {
        Log.e("MicroMsg.BizAttrRenovator", "create Json object from extInfo error. %s.", new Object[] { paramc });
        paramc = new JSONObject();
        continue;
        str2 = localoj.ILw;
        Log.i("MicroMsg.BizAttrRenovator", "[BizAttr] UpdateInfoList key = %s, value = %s", new Object[] { str2, localoj.OzQ });
        String str3 = localoj.OzQ;
        if (!"UserName".equals(str2))
        {
          if ("NickName".equals(str2)) {
            paramau.setNickname(str3);
          }
        }
        else
        {
          label312:
          j = 1;
          label315:
          if ((j == 0) && (!a(paramc, str2, localoj.OzQ, str1)))
          {
            str3 = localoj.OzQ;
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
            paramau.AV(str3);
            break label312;
          }
          if ("PYInitial".equals(str2))
          {
            paramau.AY(str3);
            break label312;
          }
          if ("QuanPin".equals(str2))
          {
            paramau.AZ(str3);
            break label312;
          }
          if ("VerifyFlag".equals(str2))
          {
            paramau.pr(Util.getInt(str3, paramau.field_verifyFlag));
            break label312;
          }
          if ("VerifyInfo".equals(str2))
          {
            paramau.Bt(str3);
            break label312;
          }
          if ("Signature".equals(str2))
          {
            paramau.Bo(str3);
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
            localc.field_brandFlag = Util.getInt(str3, localc.field_brandFlag);
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
        str3 = localoj.OzQ;
        if ("BigHeadImgUrl".equals(str2)) {
          if (localj != null) {
            localj.osN = str3;
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
            if (localj == null) {
              break label624;
            }
            localj.osM = str3;
            break label624;
          }
        }
        label673:
        if (!"BitMask".equals(str2)) {
          break;
        }
        l1 = Util.getLong(localoj.OzQ, l1);
        i += 1;
      }
      if (!"BitVal".equals(str2)) {
        break label981;
      }
    }
    long l2 = Util.getLong(localoj.OzQ, l2);
    i += 1;
    label981:
    for (;;)
    {
      break;
      label732:
      if (i == 0)
      {
        Log.i("MicroMsg.BizAttrRenovator", "None attribute has been updated.");
        AppMethodBeat.o(123982);
        return false;
      }
      localc.field_extInfo = paramc.toString();
      if ((localj != null) && (k != 0))
      {
        q.bFE().b(localj);
        q.bFp();
        AvatarStorage.T(str1, false);
        q.bFp();
        AvatarStorage.T(str1, true);
        q.bFG().LB(str1);
        paramc = af.bHr();
        if (!Util.isNullOrNil(str1))
        {
          Log.d("MicroMsg.BrandLogic", "remove cache by brandKey : %s", new Object[] { str1 });
          paramc = (WeakReference)paramc.owG.remove(str1);
          if (paramc != null)
          {
            paramc = (Bitmap)paramc.get();
            if (paramc != null) {
              paramc.isRecycled();
            }
          }
        }
      }
      paramau.setType(paramau.field_type | (int)(l1 & l2));
      i = ((n)h.ax(n.class)).bzA().d(str1, paramau);
      af.bHf().h(localc);
      if (i == 1) {
        ((n)h.ax(n.class)).bzA().doNotify(4, (MStorageEx)((n)h.ax(n.class)).bzA(), str1);
      }
      Log.i("MicroMsg.BizAttrRenovator", "Update bizInfo attributes successfully.");
      AppMethodBeat.o(123982);
      return true;
    }
  }
  
  private static boolean a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(239485);
    try
    {
      if ("IsShowHeadImgInMsg".equals(paramString1)) {
        paramJSONObject.put(paramString1, paramString2);
      }
      for (;;)
      {
        AppMethodBeat.o(239485);
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
        Log.e("MicroMsg.BizAttrRenovator", "updateExtInfoAttrs failed, key(%s) value(%s), exception : %s.", new Object[] { paramString1, paramString2, paramJSONObject });
        continue;
        if (!"IsAgreeProtocol".equals(paramString1)) {
          if ("InteractiveMode".equals(paramString1)) {
            paramJSONObject.put(paramString1, Util.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("CanReceiveSpeexVoice".equals(paramString1)) {
            paramJSONObject.put(paramString1, paramString2);
          } else if ("ConnectorMsgType".equals(paramString1)) {
            paramJSONObject.put(paramString1, Util.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("ReportLocationType".equals(paramString1)) {
            paramJSONObject.put(paramString1, Util.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("AudioPlayType".equals(paramString1)) {
            paramJSONObject.put(paramString1, Util.getInt(paramString2, paramJSONObject.optInt(paramString1)));
          } else if ("IsShowMember".equals(paramString1)) {
            paramJSONObject.put(paramString1, paramString2);
          } else if ("ConferenceContactExpireTime".equals(paramString1)) {
            paramJSONObject.put(paramString1, paramString2);
          } else if (!"VerifyMsg2Remark".equals(paramString1)) {
            if ("VerifyContactPromptTitle".equals(paramString1)) {
              paramJSONObject.put(paramString1, paramString2);
            } else if (!"IsSubscribeStat".equals(paramString1)) {
              if ("ScanQRCodeType".equals(paramString1)) {
                paramJSONObject.put(paramString1, Util.getInt(paramString2, paramJSONObject.optInt(paramString1)));
              } else if ("ServiceType".equals(paramString1)) {
                paramJSONObject.put(paramString1, Util.getInt(paramString2, paramJSONObject.optInt(paramString1)));
              } else if (!"NeedShowUserAddrObtaining".equals(paramString1)) {
                if ("SupportEmoticonLinkPrefix".equals(paramString1)) {
                  paramJSONObject.put(paramString1, paramString2);
                } else if ("FunctionFlag".equals(paramString1)) {
                  paramJSONObject.put(paramString1, Util.getInt(paramString2, paramJSONObject.optInt(paramString1)));
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
                      Log.i("MicroMsg.BizAttrRenovator", "username.equals(ContactStorageLogic.SPUSER_WXPAY_COLLECTION),dont update MMBizMenu.");
                      AppMethodBeat.o(239485);
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
      AppMethodBeat.o(239485);
    }
    return false;
  }
  
  public static boolean bGz()
  {
    AppMethodBeat.i(123980);
    Object localObject = h.baE().ban().get(at.a.acKi, null);
    if ((localObject == null) || (!(localObject instanceof Integer))) {
      Log.i("MicroMsg.BizAttrRenovator", "openFlag is null.");
    }
    for (int i = 1;; i = ((Integer)localObject).intValue())
    {
      Log.i("MicroMsg.BizAttrRenovator", "openFlag is %d.", new Object[] { Integer.valueOf(i) });
      if (i != 1) {
        break;
      }
      AppMethodBeat.o(123980);
      return true;
    }
    AppMethodBeat.o(123980);
    return false;
  }
  
  static boolean e(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(123979);
    if (paramc == null)
    {
      Log.i("MicroMsg.BizAttrRenovator", "BizInfo is null.");
      AppMethodBeat.o(123979);
      return false;
    }
    if (!bGz())
    {
      AppMethodBeat.o(123979);
      return false;
    }
    int j = ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("MMBizAttrSyncFreq", -1);
    int i = j;
    if (j == -1)
    {
      Log.i("MicroMsg.BizAttrRenovator", "MMBizAttrSyncFreq is null.");
      i = 3600;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramc.field_incrementUpdateTime;
    Log.i("MicroMsg.BizAttrRenovator", "currentMS(%d), lastUpdateTime(%d), freq(%d), version(%s).", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), paramc.field_attrSyncVersion });
    if (l1 - l2 >= i * 1000L)
    {
      AppMethodBeat.o(123979);
      return true;
    }
    AppMethodBeat.o(123979);
    return false;
  }
  
  public final boolean Mh(String paramString)
  {
    AppMethodBeat.i(123981);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is null or nil.");
      AppMethodBeat.o(123981);
      return false;
    }
    if (Mg(paramString))
    {
      Log.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is just delete.");
      AppMethodBeat.o(123981);
      return false;
    }
    Log.d("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes");
    com.tencent.mm.api.c localc = af.bHf().Mn(paramString);
    if (localc == null)
    {
      Log.w("MicroMsg.BizAttrRenovator", "try update biz attrs failed, bizInfo is null.");
      AppMethodBeat.o(123981);
      return false;
    }
    if (!e(localc))
    {
      Log.i("MicroMsg.BizAttrRenovator", "do not need to update biz attrs now.");
      AppMethodBeat.o(123981);
      return false;
    }
    if (paramString.equals("gh_f0a92aa7146c"))
    {
      Log.i("MicroMsg.BizAttrRenovator", "username == ContactStorageLogic.SPUSER_WXPAY_COLLECTION，go NetScene Plugin");
      h.baD().mCm.a(new aa(new a.2(this, paramString)), 0);
    }
    WeakReference localWeakReference = new WeakReference(null);
    h.baD().mCm.a(new u(paramString, localc.field_attrSyncVersion, new a.1(this, paramString, localWeakReference)), 0);
    AppMethodBeat.o(123981);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.a
 * JD-Core Version:    0.7.0.1
 */