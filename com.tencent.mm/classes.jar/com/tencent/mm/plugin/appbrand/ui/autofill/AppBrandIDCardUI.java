package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService;
import com.tencent.mm.plugin.appbrand.jsapi.pay.a.c;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.protocal.protobuf.cuw;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.cyq;
import com.tencent.mm.protocal.protobuf.cyr;
import com.tencent.mm.protocal.protobuf.dex;
import com.tencent.mm.protocal.protobuf.dey;
import com.tencent.mm.protocal.protobuf.dpg;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.dps;
import com.tencent.mm.protocal.protobuf.gw;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.protocal.protobuf.hb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import d.y;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class AppBrandIDCardUI
  extends MMActivity
{
  public static final int mgH = 2131296738;
  private String appId;
  private int hnS;
  private e iky;
  public MMFragment mgI;
  private cyr mgJ;
  private hb mgK;
  private LinkedList<Integer> mgL;
  private String mgM;
  private String mgN;
  private String mgO;
  private int mgP;
  private com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a mgQ;
  private p mgR;
  private PhoneItem mgS;
  private a mgt;
  
  public AppBrandIDCardUI()
  {
    AppMethodBeat.i(48952);
    this.mgt = new a()
    {
      public final void Rg(String paramAnonymousString)
      {
        AppMethodBeat.i(48932);
        ac.i("MicroMsg.AppBrandIDCardUI", "protocalUrl click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48932);
      }
      
      public final void Rh(String paramAnonymousString)
      {
        AppMethodBeat.i(48933);
        ac.i("MicroMsg.AppBrandIDCardUI", "urlJump click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48933);
      }
      
      public final void Ri(String paramAnonymousString)
      {
        AppMethodBeat.i(48934);
        ac.i("MicroMsg.AppBrandIDCardUI", "url2Jump click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48934);
      }
      
      public final void a(ha paramAnonymousha)
      {
        AppMethodBeat.i(48937);
        com.tencent.mm.plugin.report.service.h.wUl.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(7), AppBrandIDCardUI.i(AppBrandIDCardUI.this).ddJ });
        ac.i("MicroMsg.AppBrandIDCardUI", "sendSms");
        Object localObject = new b.a();
        ((b.a)localObject).hvt = new cuw();
        ((b.a)localObject).hvu = new cux();
        ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/sendsms";
        ((b.a)localObject).funcId = 1762;
        ((b.a)localObject).reqCmdId = 0;
        ((b.a)localObject).respCmdId = 0;
        localObject = ((b.a)localObject).aAz();
        cuw localcuw = (cuw)((com.tencent.mm.ak.b)localObject).hvr.hvw;
        localcuw.djj = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localcuw.FGa = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localcuw.FGb = AppBrandIDCardUI.l(AppBrandIDCardUI.this);
        localcuw.DUi = paramAnonymousha.DUi;
        localcuw.cZz = paramAnonymousha.cZz;
        localcuw.ddJ = AppBrandIDCardUI.i(AppBrandIDCardUI.this).ddJ;
        if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.j(AppBrandIDCardUI.this).lJZ)) {
          localcuw.FGc = bs.nullAsNil(AppBrandIDCardUI.j(AppBrandIDCardUI.this).dnz);
        }
        IPCRunCgi.a((com.tencent.mm.ak.b)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.b paramAnonymous2b)
          {
            AppMethodBeat.i(48926);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (paramAnonymous2b.hvs.hvw == null))
            {
              ac.e("MicroMsg.AppBrandIDCardUI", "sendSms cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, paramAnonymous2b.hvs.hvw });
              Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(2131755458), 0).show();
              AppMethodBeat.o(48926);
              return;
            }
            paramAnonymous2String = (cux)paramAnonymous2b.hvs.hvw;
            if (paramAnonymous2String.FGd != null)
            {
              ac.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response.err_code:%d", new Object[] { Integer.valueOf(paramAnonymous2String.FGd.dkl) });
              if (paramAnonymous2String.FGd.dkl == 0)
              {
                AppBrandIDCardUI.c(AppBrandIDCardUI.this, paramAnonymous2String.FGe);
                ac.i("MicroMsg.AppBrandIDCardUI", "send success, verifyToken:%s", new Object[] { paramAnonymous2String.FGe });
                AppMethodBeat.o(48926);
                return;
              }
              AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755464));
              AppMethodBeat.o(48926);
              return;
            }
            ac.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response is null");
            AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755464));
            AppMethodBeat.o(48926);
          }
        });
        AppMethodBeat.o(48937);
      }
      
      public final void a(String paramAnonymousString, ha paramAnonymousha)
      {
        AppMethodBeat.i(48938);
        if (bs.isNullOrNil(paramAnonymousString))
        {
          ac.e("MicroMsg.AppBrandIDCardUI", "verifyCode is null, err, return");
          AppMethodBeat.o(48938);
          return;
        }
        ac.i("MicroMsg.AppBrandIDCardUI", "verifySms");
        Object localObject = new b.a();
        ((b.a)localObject).hvt = new dpg();
        ((b.a)localObject).hvu = new dph();
        ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/verifysmscode";
        ((b.a)localObject).funcId = 1721;
        ((b.a)localObject).reqCmdId = 0;
        ((b.a)localObject).respCmdId = 0;
        localObject = ((b.a)localObject).aAz();
        dpg localdpg = (dpg)((com.tencent.mm.ak.b)localObject).hvr.hvw;
        localdpg.djj = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localdpg.FGa = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localdpg.FGb = AppBrandIDCardUI.l(AppBrandIDCardUI.this);
        localdpg.DUi = paramAnonymousha.DUi;
        localdpg.ddJ = AppBrandIDCardUI.i(AppBrandIDCardUI.this).ddJ;
        localdpg.BzM = paramAnonymousString;
        localdpg.FGe = AppBrandIDCardUI.m(AppBrandIDCardUI.this);
        localdpg.cZz = paramAnonymousha.cZz;
        if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.j(AppBrandIDCardUI.this).lJZ)) {
          localdpg.FGc = bs.nullAsNil(AppBrandIDCardUI.j(AppBrandIDCardUI.this).dnz);
        }
        IPCRunCgi.a((com.tencent.mm.ak.b)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.b paramAnonymous2b)
          {
            AppMethodBeat.i(48927);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (paramAnonymous2b.hvs.hvw == null))
            {
              ac.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, paramAnonymous2b.hvs.hvw });
              Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(2131755458), 0).show();
              AppMethodBeat.o(48927);
              return;
            }
            paramAnonymous2String = (dph)paramAnonymous2b.hvs.hvw;
            if (paramAnonymous2String.FGd != null)
            {
              ac.i("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response errcode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2String.FGd.dkl), bs.nullAsNil(paramAnonymous2String.FGd.dkm) });
              com.tencent.mm.plugin.report.service.h.wUl.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(8), AppBrandIDCardUI.i(AppBrandIDCardUI.this).ddJ });
              if (paramAnonymous2String.FGd.dkl == 0)
              {
                com.tencent.mm.plugin.report.service.h.wUl.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(9), AppBrandIDCardUI.i(AppBrandIDCardUI.this).ddJ });
                ac.i("MicroMsg.AppBrandIDCardUI", "verify success");
                ac.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymous2String.Eua });
                if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null))
                {
                  paramAnonymous2b = r.lKd;
                  r.b(AppBrandIDCardUI.j(AppBrandIDCardUI.this));
                }
                paramAnonymous2b = new Intent();
                paramAnonymous2b.putExtra("intent_err_code", paramAnonymous2String.FGd.dkl);
                paramAnonymous2b.putExtra("intent_auth_token", paramAnonymous2String.Eua);
                AppBrandIDCardUI.this.setResult(-1, paramAnonymous2b);
                AppBrandIDCardUI.this.finish();
                AppMethodBeat.o(48927);
                return;
              }
              if (paramAnonymous2String.FGd.dkl == 40013)
              {
                AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755463));
                AppMethodBeat.o(48927);
                return;
              }
              AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755462));
              AppMethodBeat.o(48927);
              return;
            }
            ac.e("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response is null");
            AppMethodBeat.o(48927);
          }
        });
        AppMethodBeat.o(48938);
      }
      
      public final void back()
      {
        AppMethodBeat.i(48931);
        AppBrandIDCardUI.h(AppBrandIDCardUI.this);
        AppMethodBeat.o(48931);
      }
      
      public final void bvL()
      {
        AppMethodBeat.i(48929);
        Object localObject = new b.a();
        ((b.a)localObject).hvt = new cyq();
        ((b.a)localObject).hvu = new cyr();
        ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/showauthorizeuserid";
        ((b.a)localObject).funcId = 1774;
        ((b.a)localObject).reqCmdId = 0;
        ((b.a)localObject).respCmdId = 0;
        localObject = ((b.a)localObject).aAz();
        cyq localcyq = (cyq)((com.tencent.mm.ak.b)localObject).hvr.hvw;
        localcyq.djj = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localcyq.FGa = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localcyq.FHM = AppBrandIDCardUI.c(AppBrandIDCardUI.this);
        IPCRunCgi.a((com.tencent.mm.ak.b)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.b paramAnonymous2b)
          {
            AppMethodBeat.i(48922);
            if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
              AppBrandIDCardUI.d(AppBrandIDCardUI.this).dismiss();
            }
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (paramAnonymous2b.hvs.hvw == null))
            {
              ac.e("MicroMsg.AppBrandIDCardUI", "getIDCardInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, paramAnonymous2b.hvs.hvw });
              paramAnonymous2String = new Intent();
              paramAnonymous2String.putExtra("intent_err_code", 40000);
              paramAnonymous2String.putExtra("intent_err_msg", "network err");
              AppBrandIDCardUI.this.setResult(1, paramAnonymous2String);
              AppBrandIDCardUI.this.finish();
              AppMethodBeat.o(48922);
              return;
            }
            paramAnonymous2String = (cyr)paramAnonymous2b.hvs.hvw;
            if (paramAnonymous2String.FGd == null)
            {
              ac.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
              paramAnonymous2String = new Intent();
              paramAnonymous2String.putExtra("intent_err_code", 40000);
              paramAnonymous2String.putExtra("intent_err_msg", "network err");
              AppBrandIDCardUI.this.setResult(1, paramAnonymous2String);
              AppBrandIDCardUI.this.finish();
              AppMethodBeat.o(48922);
              return;
            }
            ac.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response.err_code is %d", new Object[] { Integer.valueOf(paramAnonymous2String.FGd.dkl) });
            ac.i("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status:%d", new Object[] { Integer.valueOf(paramAnonymous2String.FHN) });
            switch (paramAnonymous2String.FHN)
            {
            default: 
              ac.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status error");
            case 0: 
              do
              {
                AppMethodBeat.o(48922);
                return;
                if (paramAnonymous2String.FGd.dkl != 0)
                {
                  ac.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is not ok");
                  paramAnonymous2b = new Intent();
                  paramAnonymous2b.putExtra("intent_err_code", paramAnonymous2String.FGd.dkl);
                  paramAnonymous2b.putExtra("intent_err_msg", paramAnonymous2String.FGd.dkm);
                  AppBrandIDCardUI.this.setResult(1, paramAnonymous2b);
                  AppBrandIDCardUI.this.finish();
                  AppMethodBeat.o(48922);
                  return;
                }
                AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymous2String);
                if (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 0)
                {
                  AppBrandIDCardUI.f(AppBrandIDCardUI.this);
                  AppMethodBeat.o(48922);
                  return;
                }
              } while (AppBrandIDCardUI.e(AppBrandIDCardUI.this) != 1);
              AppBrandIDCardUI.g(AppBrandIDCardUI.this);
              AppMethodBeat.o(48922);
              return;
            }
            ac.i("MicroMsg.AppBrandIDCardUI", "showAlert errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2String.FGd.dkl), paramAnonymous2String.FGd.dkm });
            paramAnonymous2b = AppBrandIDCardUI.1.this;
            paramAnonymous2Int1 = paramAnonymous2String.FGd.dkl;
            String str = paramAnonymous2String.FGd.dkm;
            com.tencent.mm.ui.base.h.a(paramAnonymous2b.mgT, false, paramAnonymous2String.FHO.desc, paramAnonymous2String.FHO.title, paramAnonymous2b.mgT.getString(2131755459), "", new AppBrandIDCardUI.1.2(paramAnonymous2b, paramAnonymous2Int1, str), new AppBrandIDCardUI.1.3(paramAnonymous2b));
            AppMethodBeat.o(48922);
          }
        });
        AppMethodBeat.o(48929);
      }
      
      public final void bvM()
      {
        AppMethodBeat.i(48935);
        ac.i("MicroMsg.AppBrandIDCardUI", "verifyPassword");
        com.tencent.mm.plugin.report.service.h.wUl.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(2), AppBrandIDCardUI.i(AppBrandIDCardUI.this).ddJ });
        if (AppBrandIDCardUI.i(AppBrandIDCardUI.this).FHV == null)
        {
          ac.e("MicroMsg.AppBrandIDCardUI", "showAuthorizeUserIDResp.verify_pay_req is null");
          AppMethodBeat.o(48935);
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("appId", AppBrandIDCardUI.i(AppBrandIDCardUI.this).FHV.djj);
          localJSONObject.put("timeStamp", AppBrandIDCardUI.i(AppBrandIDCardUI.this).FHV.cJz);
          localJSONObject.put("nonceStr", AppBrandIDCardUI.i(AppBrandIDCardUI.this).FHV.Fbl);
          localJSONObject.put("package", AppBrandIDCardUI.i(AppBrandIDCardUI.this).FHV.FWW);
          localJSONObject.put("signType", AppBrandIDCardUI.i(AppBrandIDCardUI.this).FHV.ofa);
          localJSONObject.put("paySign", AppBrandIDCardUI.i(AppBrandIDCardUI.this).FHV.FaK);
          com.tencent.mm.plugin.report.service.h.wUl.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(3), AppBrandIDCardUI.i(AppBrandIDCardUI.this).ddJ });
          AppBrandJsApiPayService.kGg.verifyPassword(AppBrandIDCardUI.this, null, localJSONObject, new a.c()
          {
            public final void m(boolean paramAnonymous2Boolean, final String paramAnonymous2String)
            {
              AppMethodBeat.i(48925);
              if (paramAnonymous2Boolean)
              {
                com.tencent.mm.plugin.report.service.h.wUl.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(4), AppBrandIDCardUI.i(AppBrandIDCardUI.this).ddJ });
                Object localObject = new b.a();
                ((b.a)localObject).hvt = new dex();
                ((b.a)localObject).hvu = new dey();
                ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/submitauthorizeuserid";
                ((b.a)localObject).funcId = 1721;
                ((b.a)localObject).reqCmdId = 0;
                ((b.a)localObject).respCmdId = 0;
                localObject = ((b.a)localObject).aAz();
                dex localdex = (dex)((com.tencent.mm.ak.b)localObject).hvr.hvw;
                localdex.djj = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
                localdex.FGa = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
                localdex.FGb = paramAnonymous2String;
                localdex.ddJ = AppBrandIDCardUI.i(AppBrandIDCardUI.this).ddJ;
                if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.j(AppBrandIDCardUI.this).lJZ)) {
                  localdex.FGc = bs.nullAsNil(AppBrandIDCardUI.j(AppBrandIDCardUI.this).dnz);
                }
                if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
                  AppBrandIDCardUI.d(AppBrandIDCardUI.this).show();
                }
                IPCRunCgi.a((com.tencent.mm.ak.b)localObject, new IPCRunCgi.a()
                {
                  public final void a(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, com.tencent.mm.ak.b paramAnonymous3b)
                  {
                    AppMethodBeat.i(48924);
                    if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
                      AppBrandIDCardUI.d(AppBrandIDCardUI.this).dismiss();
                    }
                    if ((paramAnonymous3Int1 != 0) || (paramAnonymous3Int2 != 0) || (paramAnonymous3b.hvs.hvw == null))
                    {
                      ac.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String, paramAnonymous3b.hvs.hvw });
                      AppMethodBeat.o(48924);
                      return;
                    }
                    paramAnonymous3String = (dey)paramAnonymous3b.hvs.hvw;
                    if (paramAnonymous3String.FGd == null)
                    {
                      ac.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                      Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(2131755458), 0).show();
                      AppMethodBeat.o(48924);
                      return;
                    }
                    ac.i("MicroMsg.AppBrandIDCardUI", "resp.auth_status:%d", new Object[] { Integer.valueOf(paramAnonymous3String.DTW) });
                    switch (paramAnonymous3String.DTW)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(48924);
                      return;
                      ac.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymous3String.Eua });
                      com.tencent.mm.plugin.report.service.h.wUl.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(9), AppBrandIDCardUI.i(AppBrandIDCardUI.this).ddJ });
                      if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null))
                      {
                        paramAnonymous3b = r.lKd;
                        r.b(AppBrandIDCardUI.j(AppBrandIDCardUI.this));
                      }
                      paramAnonymous3b = new Intent();
                      paramAnonymous3b.putExtra("intent_err_code", paramAnonymous3String.FGd.dkl);
                      paramAnonymous3b.putExtra("intent_auth_token", paramAnonymous3String.Eua);
                      AppBrandIDCardUI.this.setResult(-1, paramAnonymous3b);
                      AppBrandIDCardUI.this.finish();
                      AppMethodBeat.o(48924);
                      return;
                      com.tencent.mm.plugin.report.service.h.wUl.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(5), AppBrandIDCardUI.i(AppBrandIDCardUI.this).ddJ });
                      AppBrandIDCardUI.b(AppBrandIDCardUI.this, paramAnonymous2String);
                      AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymous3String.FOq);
                      AppBrandIDCardUI.k(AppBrandIDCardUI.this);
                    }
                  }
                });
              }
              for (;;)
              {
                ac.i("MicroMsg.AppBrandIDCardUI", "verifyOk:%b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
                AppMethodBeat.o(48925);
                return;
                if (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1)
                {
                  AppBrandIDCardUI.this.setResult(0);
                  AppBrandIDCardUI.this.finish();
                }
              }
            }
          });
          AppMethodBeat.o(48935);
          return;
        }
        catch (JSONException localJSONException)
        {
          ac.printErrStackTrace("MicroMsg.AppBrandIDCardUI", localJSONException, "", new Object[0]);
          AppMethodBeat.o(48935);
        }
      }
      
      public final void bvN()
      {
        AppMethodBeat.i(48936);
        com.tencent.mm.plugin.report.service.h.wUl.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(6), AppBrandIDCardUI.i(AppBrandIDCardUI.this).ddJ });
        AppMethodBeat.o(48936);
      }
      
      public final cyr bvO()
      {
        AppMethodBeat.i(48939);
        cyr localcyr = AppBrandIDCardUI.i(AppBrandIDCardUI.this);
        AppMethodBeat.o(48939);
        return localcyr;
      }
      
      public final hb bvP()
      {
        AppMethodBeat.i(48940);
        hb localhb = AppBrandIDCardUI.n(AppBrandIDCardUI.this);
        AppMethodBeat.o(48940);
        return localhb;
      }
      
      public final void onSwipeBack()
      {
        AppMethodBeat.i(48930);
        AppBrandIDCardUI.this.onSwipeBack();
        AppMethodBeat.o(48930);
      }
    };
    AppMethodBeat.o(48952);
  }
  
  private static LinkedList<Integer> K(Bundle paramBundle)
  {
    AppMethodBeat.i(48960);
    LinkedList localLinkedList = new LinkedList();
    try
    {
      paramBundle = paramBundle.getString("intent_category_id");
      ac.i("MicroMsg.AppBrandIDCardUI", "[processCategoryId] categoryIdStr:%s", new Object[] { paramBundle });
      paramBundle = new JSONArray(paramBundle);
      int i = 0;
      while (i < paramBundle.length())
      {
        localLinkedList.add(Integer.valueOf(paramBundle.optInt(i)));
        i += 1;
      }
      AppMethodBeat.o(48960);
      return localLinkedList;
    }
    catch (JSONException paramBundle)
    {
      ac.printErrStackTrace("MicroMsg.AppBrandIDCardUI", paramBundle, "", new Object[0]);
      AppMethodBeat.o(48960);
    }
    return null;
  }
  
  private void back()
  {
    AppMethodBeat.i(48956);
    if (((this.mgI instanceof AppBrandIDCardVerifyPwdFrag)) && (this.mgP == 0))
    {
      bvK();
      AppMethodBeat.o(48956);
      return;
    }
    if ((this.mgP != 1) || (this.iky == null) || (!this.iky.onBackPressed())) {
      finish();
    }
    AppMethodBeat.o(48956);
  }
  
  private void bvK()
  {
    AppMethodBeat.i(48961);
    ac.i("MicroMsg.AppBrandIDCardUI", "switchToShowFragment");
    this.mgI = new AppBrandIDCardShowFrag();
    ((AppBrandIDCardShowFrag)this.mgI).mgt = this.mgt;
    getSupportFragmentManager().beginTransaction().b(mgH, this.mgI).commitAllowingStateLoss();
    AppMethodBeat.o(48961);
  }
  
  public void finish()
  {
    AppMethodBeat.i(48958);
    if ((this.mgR != null) && (this.mgR.isShowing())) {
      this.mgR.dismiss();
    }
    if ((this.iky != null) && (this.mgQ != null)) {
      this.iky.c(this.mgQ);
    }
    super.finish();
    if (this.mgP == 1) {
      overridePendingTransition(0, 0);
    }
    AppMethodBeat.o(48958);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48959);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.i("MicroMsg.AppBrandIDCardUI", "onActivityResult, requestcode: %d", new Object[] { Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48959);
      return;
      if (this.mgQ != null)
      {
        paramIntent = this.mgQ;
        r localr = r.lKd;
        paramIntent.x((ArrayList)r.bss());
        AppMethodBeat.o(48959);
        return;
      }
      ac.e("MicroMsg.AppBrandIDCardUI", "onActivityResult, AuthDialog is null");
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(48955);
    back();
    AppMethodBeat.o(48955);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48954);
    Object localObject = getIntent().getExtras();
    if (localObject != null) {
      this.mgP = ((Bundle)localObject).getInt("id_ui_theme", 0);
    }
    super.onCreate(paramBundle);
    if (localObject == null)
    {
      ac.e("MicroMsg.AppBrandIDCardUI", "bundle is null, return");
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.appId = ((Bundle)localObject).getString("intent_appid", "");
    if (bs.isNullOrNil(this.appId))
    {
      ac.e("MicroMsg.AppBrandIDCardUI", "appId is null, return");
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.mgL = K((Bundle)localObject);
    if ((bs.gY(this.mgL)) || (this.mgL.size() <= 0))
    {
      ac.e("MicroMsg.AppBrandIDCardUI", "categoryId is null, return");
      paramBundle = new Intent();
      paramBundle.putExtra("intent_err_code", 40003);
      paramBundle.putExtra("intent_err_msg", "category_id is null");
      setResult(1, paramBundle);
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.hnS = ((Bundle)localObject).getInt("intent_auth_type", 1);
    getContentView().setBackgroundColor(getResources().getColor(2131100705));
    paramBundle = new ViewGroup.LayoutParams(-1, -1);
    localObject = new FrameLayout(this);
    ((View)localObject).setId(mgH);
    ((ViewGroup)getContentView()).addView((View)localObject, paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48944);
        AppBrandIDCardUI.h(AppBrandIDCardUI.this);
        AppMethodBeat.o(48944);
        return true;
      }
    });
    getString(2131755906);
    this.mgR = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(48945);
        AppBrandIDCardUI.this.setResult(0);
        AppBrandIDCardUI.this.finish();
        AppMethodBeat.o(48945);
      }
    });
    this.mgR.show();
    if (this.mgP == 1)
    {
      aj.b(getWindow());
      getContentView().setBackgroundColor(0);
      getContentView().findViewById(mgH).setBackgroundColor(0);
      this.iky = new e(getContext());
      paramBundle = ((ViewGroup)getWindow().getDecorView()).getChildAt(0);
      if (!(((ViewGroup)getWindow().getDecorView()).getChildAt(0) instanceof ViewGroup)) {
        break label480;
      }
      ac.i("MicroMsg.AppBrandIDCardUI", "find sub viewgroup in decorview");
      paramBundle.setFitsSystemWindows(false);
    }
    for (;;)
    {
      try
      {
        ((ViewGroup)paramBundle).addView(this.iky);
        this.mgt.bvL();
        if (isSupportNavigationSwipeBack()) {
          getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(48954);
        return;
      }
      catch (Exception paramBundle)
      {
        ac.w("MicroMsg.AppBrandIDCardUI", "add view to decorSubView error", new Object[] { paramBundle });
        ((ViewGroup)getContentView()).addView(this.iky);
        continue;
      }
      label480:
      ac.i("MicroMsg.AppBrandIDCardUI", "can't find sub viewgroup in decorview");
      ((ViewGroup)getContentView()).addView(this.iky);
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(48953);
    super.onCreateBeforeSetContentView();
    if (this.mgP == 1) {
      setTheme(2131821149);
    }
    getWindow().requestFeature(10);
    getWindow().getDecorView().setFitsSystemWindows(true);
    supportRequestWindowFeature(10);
    supportRequestWindowFeature(1);
    AppMethodBeat.o(48953);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(48957);
    back();
    AppMethodBeat.o(48957);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void Rg(String paramString);
    
    public abstract void Rh(String paramString);
    
    public abstract void Ri(String paramString);
    
    public abstract void a(ha paramha);
    
    public abstract void a(String paramString, ha paramha);
    
    public abstract void back();
    
    public abstract void bvL();
    
    public abstract void bvM();
    
    public abstract void bvN();
    
    public abstract cyr bvO();
    
    public abstract hb bvP();
    
    public abstract void onSwipeBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI
 * JD-Core Version:    0.7.0.1
 */