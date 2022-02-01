package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo;
import com.tencent.mm.plugin.appbrand.o.d;
import com.tencent.mm.plugin.appbrand.o.e.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.c;
import com.tencent.mm.protocal.protobuf.bmb;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import d.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiOperateWXData
  extends h
{
  public static final int CTRL_INDEX = 79;
  public static final String NAME = "operateWXData";
  private final k keA;
  
  public JsApiOperateWXData()
  {
    AppMethodBeat.i(174777);
    this.keA = new k();
    AppMethodBeat.o(174777);
  }
  
  public static void clear(String paramString)
  {
    AppMethodBeat.i(46104);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(46104);
      return;
    }
    try
    {
      OperateWXDataTask.bfo();
      String[] arrayOfString = OperateWXDataTask.aeY().allKeys();
      if (arrayOfString == null)
      {
        AppMethodBeat.o(46104);
        return;
      }
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((!TextUtils.isEmpty(str)) && (str.startsWith(paramString))) {
          OperateWXDataTask.aeY().remove(str);
        }
        i += 1;
      }
      AppMethodBeat.o(46104);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.AppBrand.JsApiOperateWXData", "clear(%s) e=%s", new Object[] { paramString, localThrowable });
      AppMethodBeat.o(46104);
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(46103);
    for (;;)
    {
      try
      {
        String str = paramJSONObject.getString("data");
        boolean bool = paramJSONObject.optBoolean("isImportant");
        paramJSONObject = new OperateWXDataTask();
        paramJSONObject.appId = paramh.getAppId();
        paramJSONObject.kdE = "operateWXData";
        com.tencent.mm.plugin.appbrand.config.k localk = paramh.getRuntime().DI();
        if (localk != null) {
          paramJSONObject.hxM = localk.jEg.jpa;
        }
        paramJSONObject.kdA = this;
        paramJSONObject.kdB = paramh;
        paramJSONObject.keC = str;
        paramJSONObject.keL = bool;
        paramJSONObject.jOT = paramInt;
        paramJSONObject.kdC = parame;
        paramJSONObject.keH = new HashMap();
        parame = a.GW(paramJSONObject.appId);
        if (parame != null) {
          paramJSONObject.jZF = parame.scene;
        }
        if ((paramh instanceof com.tencent.mm.plugin.appbrand.q))
        {
          paramJSONObject.kdS = 1;
          paramJSONObject.bej();
          AppBrandMainProcessService.a(paramJSONObject);
          AppMethodBeat.o(46103);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        ac.e("MicroMsg.AppBrand.JsApiOperateWXData", "Exception %s", new Object[] { paramJSONObject.getMessage() });
        paramh.h(paramInt, e("fail", null));
        parame.bfe();
        AppMethodBeat.o(46103);
        return;
      }
      if ((paramh instanceof aa)) {
        paramJSONObject.kdS = 2;
      }
    }
  }
  
  static class OperateWXDataTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateWXDataTask> CREATOR;
    private static final aw keB;
    public String appId;
    public int hxM;
    public int jOT;
    int jZF;
    h kdA;
    com.tencent.mm.plugin.appbrand.jsapi.h kdB;
    e kdC;
    public String kdE;
    public String kdF;
    public int kdG;
    public String kdH;
    public String kdI;
    public String kdJ;
    public String kdK;
    public boolean kdL;
    public String kdM;
    public String kdN;
    public String kdO;
    public int kdP;
    public String kdR;
    int kdS;
    public String keC;
    public String keD;
    public String keE;
    public int keF;
    public String keG;
    public Map<String, byte[]> keH;
    public MMUserAvatarInfo keI;
    int keJ;
    private boolean keK;
    boolean keL;
    public String mAppName;
    
    static
    {
      AppMethodBeat.i(46102);
      keB = aw.aKT("MicroMsg.AppBrand.JsApiOperateWXData");
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46102);
    }
    
    public OperateWXDataTask()
    {
      AppMethodBeat.i(174776);
      this.kdO = "";
      this.kdN = "";
      AppMethodBeat.o(174776);
    }
    
    public OperateWXDataTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46085);
      this.kdO = "";
      this.kdN = "";
      e(paramParcel);
      AppMethodBeat.o(46085);
    }
    
    private void a(String paramString1, final String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, final a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(46092);
      if (!paramBoolean) {
        ac.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateWxData");
      }
      for (paramString1 = new com.tencent.mm.plugin.appbrand.o.e(paramString1, paramString2, paramString3, paramInt1, paramInt3, paramInt2, this.jZF, new e.a() {});; paramString1 = new d(paramString1, paramString2, paramString3, paramInt1, paramInt3, paramInt2, this.jZF, new e.a() {}))
      {
        paramString1.ua(this.kdS);
        com.tencent.mm.kernel.g.agi().a(paramString1, 0);
        AppMethodBeat.o(46092);
        return;
        ac.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateImportantWxData");
      }
    }
    
    static void bfo() {}
    
    final void a(int paramInt1, int paramInt2, String paramString1, com.tencent.mm.plugin.appbrand.o.e parame, String paramString2, a parama)
    {
      AppMethodBeat.i(46093);
      ac.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1 });
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        parama.bZ(String.format("cgi fail(%d,%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(46093);
        return;
      }
      if (parame != null)
      {
        if (this.kdG == 2)
        {
          ac.d("MicroMsg.AppBrand.JsApiOperateWXData", "press reject button");
          AppMethodBeat.o(46093);
          return;
        }
        if (parame.rr == null) {}
        for (paramString1 = null; paramString1.FbT == null; paramString1 = (bmx)parame.rr.hvs.hvw)
        {
          ac.d("MicroMsg.AppBrand.JsApiOperateWXData", "JsApiBaseResponse is null, enterData:".concat(String.valueOf(paramString2)));
          parama.bZ("cgi fail response null");
          AppMethodBeat.o(46093);
          return;
        }
        paramInt1 = paramString1.FbT.dfm;
        parame = paramString1.FbT.dfn;
        Object localObject = paramString1.Fcf;
        LinkedList localLinkedList = new LinkedList();
        if (localObject != null) {
          localLinkedList.add(localObject);
        }
        localObject = paramString1.tkL;
        String str = paramString1.DOl;
        ac.d("MicroMsg.AppBrand.JsApiOperateWXData", "stev NetSceneJSOperateWxData jsErrcode %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 == -12000)
        {
          this.kdI = paramString1.FbX;
          this.kdK = paramString1.FbW;
          this.kdJ = paramString1.FbV;
          if (paramString1.FbY != null)
          {
            this.kdL = paramString1.FbY.DQA;
            this.kdM = paramString1.FbY.DQB;
          }
          if (paramString1.Fci != null) {
            this.keI = new MMUserAvatarInfo(paramString1.Fci);
          }
          parama.a(localLinkedList, (String)localObject, str);
          AppMethodBeat.o(46093);
          return;
        }
        if (paramInt1 == 0)
        {
          if (paramString1.ncy == null)
          {
            ac.d("MicroMsg.AppBrand.JsApiOperateWXData", "Data is null, enterData:".concat(String.valueOf(paramString2)));
            parama.bZ("internal error");
            AppMethodBeat.o(46093);
            return;
          }
          paramString1 = paramString1.ncy.eQU();
          ac.d("MicroMsg.AppBrand.JsApiOperateWXData", "resp data %s", new Object[] { paramString1 });
          parama.onSuccess(paramString1);
          AppMethodBeat.o(46093);
          return;
        }
        ac.e("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd NetSceneJSOperateWxData Failed %s", new Object[] { parame });
        parama.bZ(parame);
      }
      AppMethodBeat.o(46093);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(46086);
      a local1 = new a()
      {
        public final void a(LinkedList<csf> paramAnonymousLinkedList, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(46068);
          ac.d("MicroMsg.AppBrand.JsApiOperateWXData", "onConfirm !");
          JsApiOperateWXData.OperateWXDataTask.this.kdP = paramAnonymousLinkedList.size();
          int i = 0;
          while (i < JsApiOperateWXData.OperateWXDataTask.this.kdP)
          {
            csf localcsf = (csf)paramAnonymousLinkedList.get(i);
            try
            {
              JsApiOperateWXData.OperateWXDataTask.this.keH.put(String.valueOf(i), localcsf.toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousLinkedList)
            {
              ac.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { paramAnonymousLinkedList.getMessage() });
              ac.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", paramAnonymousLinkedList, "", new Object[0]);
              JsApiOperateWXData.OperateWXDataTask.this.kdF = "fail";
              JsApiOperateWXData.OperateWXDataTask.d(JsApiOperateWXData.OperateWXDataTask.this);
              AppMethodBeat.o(46068);
              return;
            }
          }
          JsApiOperateWXData.OperateWXDataTask.this.mAppName = paramAnonymousString1;
          JsApiOperateWXData.OperateWXDataTask.this.kdH = paramAnonymousString2;
          JsApiOperateWXData.OperateWXDataTask.this.kdF = "needConfirm";
          if (paramAnonymousLinkedList.size() > 0)
          {
            paramAnonymousString1 = (csf)paramAnonymousLinkedList.get(0);
            paramAnonymousString2 = JsApiOperateWXData.OperateWXDataTask.this;
            if (paramAnonymousString1.FEH == null)
            {
              paramAnonymousLinkedList = "";
              paramAnonymousString2.kdR = paramAnonymousLinkedList;
              if (!"scope.userInfo".equals(paramAnonymousString1.EdG)) {
                break label299;
              }
              JsApiOperateWXData.OperateWXDataTask.this.kdO = u.axy();
              paramAnonymousString1 = new StringBuilder("userNickName=");
              if (JsApiOperateWXData.OperateWXDataTask.this.kdO != null) {
                break label288;
              }
            }
            label288:
            for (paramAnonymousLinkedList = "";; paramAnonymousLinkedList = JsApiOperateWXData.OperateWXDataTask.this.kdO)
            {
              ac.i("MicroMsg.AppBrand.JsApiOperateWXData", paramAnonymousLinkedList);
              paramAnonymousLinkedList = u.axw();
              paramAnonymousString1 = g.kdw;
              g.a.a(paramAnonymousLinkedList, new g.b()
              {
                public final void HH(String paramAnonymous2String)
                {
                  AppMethodBeat.i(46065);
                  JsApiOperateWXData.OperateWXDataTask.this.kdN = paramAnonymous2String;
                  JsApiOperateWXData.OperateWXDataTask.e(JsApiOperateWXData.OperateWXDataTask.this);
                  AppMethodBeat.o(46065);
                }
              });
              AppMethodBeat.o(46068);
              return;
              paramAnonymousLinkedList = paramAnonymousString1.FEH;
              break;
            }
            label299:
            JsApiOperateWXData.OperateWXDataTask.f(JsApiOperateWXData.OperateWXDataTask.this);
            AppMethodBeat.o(46068);
            return;
          }
          JsApiOperateWXData.OperateWXDataTask.g(JsApiOperateWXData.OperateWXDataTask.this);
          AppMethodBeat.o(46068);
        }
        
        public final void bZ(String paramAnonymousString)
        {
          AppMethodBeat.i(46067);
          ac.e("MicroMsg.AppBrand.JsApiOperateWXData", "onFailure !");
          JsApiOperateWXData.OperateWXDataTask.this.kdF = "fail:".concat(String.valueOf(paramAnonymousString));
          JsApiOperateWXData.OperateWXDataTask.c(JsApiOperateWXData.OperateWXDataTask.this);
          AppMethodBeat.o(46067);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(46066);
          ac.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSuccess !");
          try
          {
            JsApiOperateWXData.OperateWXDataTask.this.keE = org.apache.commons.b.g.a(new String[] { JsApiOperateWXData.OperateWXDataTask.this.appId, JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this), JsApiOperateWXData.OperateWXDataTask.this.jOT, bs.Gn() }, "$");
            JsApiOperateWXData.OperateWXDataTask.aeY().putString(JsApiOperateWXData.OperateWXDataTask.this.keE, paramAnonymousString).commit();
            if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.aeY().getString(JsApiOperateWXData.OperateWXDataTask.this.keE, null)))
            {
              IOException localIOException = new IOException("write data failed");
              AppMethodBeat.o(46066);
              throw localIOException;
            }
          }
          catch (Throwable localThrowable)
          {
            ac.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInMainProcess::onSuccess, write to XProcessStore failed, appId[%s], callbackId[%d] e=%s", new Object[] { JsApiOperateWXData.OperateWXDataTask.this.appId, Integer.valueOf(JsApiOperateWXData.OperateWXDataTask.this.jOT), localThrowable });
            JsApiOperateWXData.OperateWXDataTask.this.keE = null;
            JsApiOperateWXData.qP(1L);
            if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.keE)) {
              JsApiOperateWXData.OperateWXDataTask.this.keD = paramAnonymousString;
            }
            for (;;)
            {
              JsApiOperateWXData.OperateWXDataTask.this.kdF = "ok";
              JsApiOperateWXData.OperateWXDataTask.b(JsApiOperateWXData.OperateWXDataTask.this);
              AppMethodBeat.o(46066);
              return;
              JsApiOperateWXData.qP(0L);
              if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.keE)) {
                JsApiOperateWXData.OperateWXDataTask.this.keD = paramAnonymousString;
              }
            }
          }
          finally
          {
            if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.keE)) {
              JsApiOperateWXData.OperateWXDataTask.this.keD = paramAnonymousString;
            }
            AppMethodBeat.o(46066);
          }
        }
      };
      if (this.kdE.equals("operateWXData"))
      {
        a(this.appId, this.keC, "", this.hxM, this.kdG, 0, local1, this.keL);
        AppMethodBeat.o(46086);
        return;
      }
      if (this.kdE.equals("operateWXDataConfirm")) {
        a(this.appId, this.keC, this.keG, this.hxM, this.kdG, this.keF, local1, this.keL);
      }
      AppMethodBeat.o(46086);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(46088);
      bek();
      if (!this.kdB.isRunning())
      {
        this.kdC.bfe();
        AppMethodBeat.o(46088);
        return;
      }
      Object localObject2;
      Object localObject1;
      if (this.kdF.equals("ok"))
      {
        localObject2 = new HashMap();
        String str = this.keD;
        localObject1 = str;
        if (!TextUtils.isEmpty(this.keE)) {
          localObject1 = str;
        }
        try
        {
          str = keB.getString(this.keE, "");
          localObject1 = str;
          keB.remove(this.keE);
          localObject1 = str;
          JsApiOperateWXData.qP(2L);
          localObject1 = str;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ac.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInClientProcess loginResult ok, get data from XProcessStore failed, appId[%s], callbackId[%d], e=%s", new Object[] { this.appId, Integer.valueOf(this.jOT), localThrowable });
            JsApiOperateWXData.qP(3L);
          }
        }
        ((Map)localObject2).put("data", localObject1);
        this.kdB.h(this.jOT, this.kdA.k("ok", (Map)localObject2));
        this.kdC.bfe();
        AppMethodBeat.o(46088);
        return;
      }
      if (this.kdF.contains("fail"))
      {
        this.kdA.b(this.kdB, this.jOT, this.kdF);
        this.kdC.bfe();
        AppMethodBeat.o(46088);
        return;
      }
      if (this.kdF.equals("needConfirm"))
      {
        localObject1 = new LinkedList();
        int i = 0;
        while (i < this.kdP)
        {
          byte[] arrayOfByte = (byte[])this.keH.get(String.valueOf(i));
          localObject2 = new csf();
          try
          {
            ((csf)localObject2).parseFrom(arrayOfByte);
            ((LinkedList)localObject1).add(localObject2);
            i += 1;
          }
          catch (IOException localIOException)
          {
            ac.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { localIOException.getMessage() });
            ac.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", localIOException, "", new Object[0]);
            this.kdA.b(this.kdB, this.jOT, "fail");
            this.kdC.bfe();
            AppMethodBeat.o(46088);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(180209);
              Object localObject1 = (csf)localIOException.getFirst();
              Object localObject2 = new i.b()
              {
                public final void a(int paramAnonymous2Int1, ArrayList<String> paramAnonymous2ArrayList, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(180203);
                  ac.i("MicroMsg.AppBrand.JsApiOperateWXData", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  switch (paramAnonymous2Int1)
                  {
                  default: 
                    ac.d("MicroMsg.AppBrand.JsApiOperateWXData", "press back button!");
                    JsApiOperateWXData.OperateWXDataTask.this.kdA.b(JsApiOperateWXData.OperateWXDataTask.this.kdB, JsApiOperateWXData.OperateWXDataTask.this.jOT, "fail auth cancel");
                    JsApiOperateWXData.OperateWXDataTask.this.kdC.bfe();
                    AppMethodBeat.o(180203);
                    return;
                  }
                  JsApiOperateWXData.OperateWXDataTask.this.kdE = "operateWXDataConfirm";
                  JsApiOperateWXData.OperateWXDataTask localOperateWXDataTask = JsApiOperateWXData.OperateWXDataTask.this;
                  if (paramAnonymous2ArrayList.size() > 0) {}
                  for (paramAnonymous2ArrayList = (String)paramAnonymous2ArrayList.get(0);; paramAnonymous2ArrayList = "")
                  {
                    localOperateWXDataTask.keG = paramAnonymous2ArrayList;
                    JsApiOperateWXData.OperateWXDataTask.this.kdG = paramAnonymous2Int1;
                    JsApiOperateWXData.OperateWXDataTask.this.keF = paramAnonymous2Int2;
                    AppBrandMainProcessService.a(JsApiOperateWXData.OperateWXDataTask.this);
                    if (paramAnonymous2Int1 != 2) {
                      break;
                    }
                    JsApiOperateWXData.OperateWXDataTask.this.kdA.b(JsApiOperateWXData.OperateWXDataTask.this.kdB, JsApiOperateWXData.OperateWXDataTask.this.jOT, "fail auth deny");
                    JsApiOperateWXData.OperateWXDataTask.this.kdC.bfe();
                    AppMethodBeat.o(180203);
                    return;
                  }
                }
              };
              boolean bool;
              if ((JsApiOperateWXData.OperateWXDataTask.this.kdB.getRuntime().getWindowAndroid() != null) && (JsApiOperateWXData.OperateWXDataTask.this.kdB.getRuntime().getWindowAndroid().aTx()))
              {
                bool = true;
                localObject2 = new i(h.c(JsApiOperateWXData.OperateWXDataTask.this.kdB), (i.b)localObject2, bool);
                ((i)localObject2).RP(JsApiOperateWXData.OperateWXDataTask.this.mAppName);
                ((i)localObject2).RQ(((csf)localObject1).Desc);
                ((i)localObject2).RS(JsApiOperateWXData.OperateWXDataTask.this.kdI);
                ((i)localObject2).Us(JsApiOperateWXData.OperateWXDataTask.this.kdJ);
                ((i)localObject2).asC(JsApiOperateWXData.OperateWXDataTask.this.kdK);
                ((i)localObject2).qV(JsApiOperateWXData.OperateWXDataTask.this.kdH);
                if ((!JsApiOperateWXData.OperateWXDataTask.this.kdL) || (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.kdM))) {
                  break label333;
                }
                ((i)localObject2).hW(true);
                ((i)localObject2).b(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(180204);
                    JsApiOperateWXData.OperateWXDataTask.this.kdB.aSs().b(new com.tencent.mm.plugin.appbrand.phonenumber.k(JsApiOperateWXData.OperateWXDataTask.this.kdB.aSs(), JsApiOperateWXData.OperateWXDataTask.this.kdB, JsApiOperateWXData.OperateWXDataTask.this.kdM, h.c(JsApiOperateWXData.OperateWXDataTask.this.kdB), this.kdX.ijA.getMeasuredHeight()));
                    AppMethodBeat.o(180204);
                  }
                });
                label192:
                if (!TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.kdR)) {
                  ((i)localObject2).RR(JsApiOperateWXData.OperateWXDataTask.this.kdR);
                }
                if (!"scope.userInfo".equals(((csf)localObject1).EdG)) {
                  break label414;
                }
                if (JsApiOperateWXData.OperateWXDataTask.this.keI == null) {
                  break label341;
                }
                localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b(JsApiOperateWXData.OperateWXDataTask.this.kdB.getContext(), JsApiOperateWXData.OperateWXDataTask.this.keI, ((csf)localObject1).EdG, new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c()
                {
                  public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2, d.g.a.m<? super Activity, ? super String, y> paramAnonymous2m)
                  {
                    AppMethodBeat.i(180205);
                    if ((paramAnonymous2Boolean1) || (paramAnonymous2Boolean2))
                    {
                      if (!paramAnonymous2Boolean1)
                      {
                        this.kdX.aBP(paramAnonymous2String1);
                        this.kdX.MP(JsApiOperateWXData.OperateWXDataTask.this.kdB.getContext().getResources().getColor(2131099660));
                      }
                      for (;;)
                      {
                        JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this, this.kdX, false, paramAnonymous2m);
                        AppMethodBeat.o(180205);
                        return;
                        this.kdX.aBP("");
                      }
                    }
                    this.kdX.aBP(paramAnonymous2String2);
                    this.kdX.MP(JsApiOperateWXData.OperateWXDataTask.this.kdB.getContext().getResources().getColor(2131100547));
                    JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this, this.kdX, true, paramAnonymous2m);
                    AppMethodBeat.o(180205);
                  }
                  
                  public final void bj(List<o.a> paramAnonymous2List)
                  {
                    AppMethodBeat.i(180206);
                    this.kdX.bG(paramAnonymous2List);
                    AppMethodBeat.o(180206);
                  }
                });
                ((i)localObject2).a(new o.b()
                {
                  public final void a(o.a paramAnonymous2a)
                  {
                    AppMethodBeat.i(180207);
                    this.keP.b(paramAnonymous2a);
                    AppMethodBeat.o(180207);
                  }
                });
                ((i)localObject2).a(new o.c()
                {
                  public final void a(View paramAnonymous2View, o.a paramAnonymous2a, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(180208);
                    paramAnonymous2a = this.keP;
                    TouchableLayout.a locala = TouchableLayout.JyS;
                    int i = TouchableLayout.fyY();
                    locala = TouchableLayout.JyS;
                    paramAnonymous2a.a(paramAnonymous2View, paramAnonymous2Int, i, TouchableLayout.fyZ());
                    AppMethodBeat.o(180208);
                  }
                });
              }
              for (;;)
              {
                JsApiOperateWXData.OperateWXDataTask.this.kdB.aSs().b((com.tencent.mm.plugin.appbrand.widget.dialog.k)localObject2);
                AppMethodBeat.o(180209);
                return;
                bool = false;
                break;
                label333:
                ((i)localObject2).hW(false);
                break label192;
                label341:
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(new o.a(JsApiOperateWXData.OperateWXDataTask.this.kdO, JsApiOperateWXData.OperateWXDataTask.this.kdB.getContext().getResources().getString(2131755946), ((csf)localObject1).EdG, com.tencent.mm.aj.e.Ae(JsApiOperateWXData.OperateWXDataTask.this.kdN), (byte)0));
                ((i)localObject2).bG(localArrayList);
                continue;
                label414:
                ((i)localObject2).aBQ(((csf)localObject1).EdG);
              }
            }
          });
          AppMethodBeat.o(46088);
          return;
        }
        this.kdA.b(this.kdB, this.jOT, "fail");
        this.kdC.bfe();
      }
      AppMethodBeat.o(46088);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46090);
      this.appId = paramParcel.readString();
      this.kdF = paramParcel.readString();
      this.mAppName = paramParcel.readString();
      this.kdH = paramParcel.readString();
      this.keC = paramParcel.readString();
      this.keD = paramParcel.readString();
      this.keE = paramParcel.readString();
      this.jOT = paramParcel.readInt();
      this.kdE = paramParcel.readString();
      this.keG = paramParcel.readString();
      this.kdP = paramParcel.readInt();
      this.keH = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.hxM = paramParcel.readInt();
      this.kdG = paramParcel.readInt();
      this.jZF = paramParcel.readInt();
      this.kdS = paramParcel.readInt();
      this.kdO = paramParcel.readString();
      this.kdN = paramParcel.readString();
      this.kdK = paramParcel.readString();
      this.kdJ = paramParcel.readString();
      this.kdI = paramParcel.readString();
      this.keI = ((MMUserAvatarInfo)paramParcel.readParcelable(MMUserAvatarInfo.class.getClassLoader()));
      this.keJ = paramParcel.readInt();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.keK = bool1;
        this.keF = paramParcel.readInt();
        if (paramParcel.readInt() != 1) {
          break label288;
        }
        bool1 = true;
        label240:
        this.keL = bool1;
        if (paramParcel.readInt() != 1) {
          break label293;
        }
      }
      label288:
      label293:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.kdL = bool1;
        this.kdM = paramParcel.readString();
        this.kdR = paramParcel.readString();
        AppMethodBeat.o(46090);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label240;
      }
    }
    
    public final void gg(boolean paramBoolean)
    {
      AppMethodBeat.i(46087);
      super.gg(paramBoolean);
      if (paramBoolean) {}
      for (long l = 4L;; l = 5L)
      {
        JsApiOperateWXData.qP(l);
        AppMethodBeat.o(46087);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(46091);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.kdF);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.kdH);
      paramParcel.writeString(this.keC);
      paramParcel.writeString(this.keD);
      paramParcel.writeString(this.keE);
      paramParcel.writeInt(this.jOT);
      paramParcel.writeString(this.kdE);
      paramParcel.writeString(this.keG);
      paramParcel.writeInt(this.kdP);
      paramParcel.writeMap(this.keH);
      paramParcel.writeInt(this.hxM);
      paramParcel.writeInt(this.kdG);
      paramParcel.writeInt(this.jZF);
      paramParcel.writeInt(this.kdS);
      paramParcel.writeString(this.kdO);
      paramParcel.writeString(this.kdN);
      paramParcel.writeString(this.kdK);
      paramParcel.writeString(this.kdJ);
      paramParcel.writeString(this.kdI);
      paramParcel.writeParcelable(this.keI, paramInt);
      paramParcel.writeInt(this.keJ);
      if (this.keK)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.keF);
        if (!this.keL) {
          break label271;
        }
        paramInt = 1;
        label224:
        paramParcel.writeInt(paramInt);
        if (!this.kdL) {
          break label276;
        }
      }
      label271:
      label276:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.kdM);
        paramParcel.writeString(this.kdR);
        AppMethodBeat.o(46091);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label224;
      }
    }
    
    public static abstract interface a
    {
      public abstract void a(LinkedList<csf> paramLinkedList, String paramString1, String paramString2);
      
      public abstract void bZ(String paramString);
      
      public abstract void onSuccess(String paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData
 * JD-Core Version:    0.7.0.1
 */