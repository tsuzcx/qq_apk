package com.tencent.mm.msgsubscription.storage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData.a;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.ui.b.d;
import com.tencent.mm.msgsubscription.ui.b.e;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController;", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgRequestController;", "()V", "TAG", "", "getSubscribeMsgList", "", "requestTask", "Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "subscribeMsgList", "SubscribeMsgRequestCallback", "SubscribeMsgRequestTask", "plugin-comm_release"})
public final class b
{
  public static final b hHx;
  
  static
  {
    AppMethodBeat.i(149633);
    hHx = new b();
    AppMethodBeat.o(149633);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(149631);
    d.g.b.k.h(paramb, "requestTask");
    paramb.run();
    AppMethodBeat.o(149631);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(149632);
    d.g.b.k.h(paramb, "requestTask");
    paramb.run();
    AppMethodBeat.o(149632);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "", "dismissProgressDialog", "", "onCancel", "onDismissDialog", "onError", "action", "", "errType", "errCode", "errMsg", "", "onGetSubscribeListSuccess", "showDialog", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onShowDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "containerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "onSubscribeMsgSuccess", "Companion", "plugin-comm_release"})
  public static abstract interface a
  {
    public static final b.a.a hHy = b.a.a.hHz;
    
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, String paramString);
    
    public abstract void a(SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void a(com.tencent.mm.plugin.appbrand.widget.dialog.k paramk, com.tencent.mm.plugin.appbrand.widget.dialog.e parame);
    
    public abstract void a(boolean paramBoolean, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void aEq();
    
    public abstract void aEr();
    
    public abstract void onCancel();
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "", "context", "Landroid/content/Context;", "action", "", "bizUsername", "", "subscribeUrl", "content", "requestCallback", "Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;)V", "getAction", "()I", "setAction", "(I)V", "getBizUsername", "()Ljava/lang/String;", "buffer", "", "getContent", "getContext", "()Landroid/content/Context;", "dataLoader", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "mDialogContainerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "mEvent", "getRequestCallback", "()Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "subscribeMsgTmpItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "getSubscribeMsgTmpItems", "()Ljava/util/ArrayList;", "setSubscribeMsgTmpItems", "(Ljava/util/ArrayList;)V", "getSubscribeUrl", "uiData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "applyUserAction", "", "event", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "", "dispatchSuccessResult", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "run", "showAlertDialog", "title", "okOnClickListener", "Landroid/content/DialogInterface$OnClickListener;", "showSettingPageAlert", "showSubscribeRequestDialog", "timestamp", "", "showToast", "msg", "callback", "Lkotlin/Function0;", "Companion", "plugin-comm_release"})
  public static final class b
  {
    public static final b.b.a hHF;
    int action;
    private byte[] buffer;
    private final String content;
    final Context context;
    final String dta;
    private final String hGW;
    ArrayList<SubscribeMsgTmpItem> hHA;
    private com.tencent.mm.plugin.appbrand.widget.dialog.e hHB;
    private int hHC;
    private SubscribeMsgRequestDialogUiData hHD;
    final b.a hHE;
    private e hHm;
    
    static
    {
      AppMethodBeat.i(149628);
      hHF = new b.b.a((byte)0);
      AppMethodBeat.o(149628);
    }
    
    public b(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, b.a parama)
    {
      AppMethodBeat.i(149627);
      this.context = paramContext;
      this.action = paramInt;
      this.dta = paramString1;
      this.hGW = paramString2;
      this.content = paramString3;
      this.hHE = parama;
      this.hHC = -1;
      this.buffer = new byte[] { 0 };
      paramContext = f.hHV;
      paramContext = f.AN("name_biz");
      if (paramContext != null) {
        this.hHm = new e(paramContext.aEs());
      }
      AppMethodBeat.o(149627);
    }
    
    private final void c(String paramString, d.g.a.a<y> parama)
    {
      AppMethodBeat.i(149626);
      if (((CharSequence)paramString).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          Toast.makeText(this.context, (CharSequence)paramString, 0).show();
        }
        parama.invoke();
        AppMethodBeat.o(149626);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(149625);
      switch (this.action)
      {
      }
      Object localObject1;
      do
      {
        AppMethodBeat.o(149625);
        return;
        int i;
        if (((CharSequence)this.hGW).length() == 0) {
          i = 1;
        }
        while (i != 0)
        {
          localObject1 = this.hHE;
          if (localObject1 != null)
          {
            ((b.a)localObject1).a(this.action, 1, -1, "invalid subscribe url");
            AppMethodBeat.o(149625);
            return;
            i = 0;
          }
          else
          {
            AppMethodBeat.o(149625);
            return;
          }
        }
        ad.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgByUrl bizUsername: %s, url: %s", new Object[] { this.dta, this.hGW });
        localObject1 = this.hHm;
        if (localObject1 != null)
        {
          ((e)localObject1).a(this.dta, this.hGW, (e.b)new e(this));
          AppMethodBeat.o(149625);
          return;
        }
        AppMethodBeat.o(149625);
        return;
        localObject1 = (Collection)this.hHA;
        if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
          i = 1;
        }
        while (i != 0)
        {
          localObject1 = this.hHE;
          if (localObject1 != null)
          {
            ((b.a)localObject1).a(this.action, 2, -1, "invalid subscribe msg list");
            AppMethodBeat.o(149625);
            return;
            i = 0;
          }
          else
          {
            AppMethodBeat.o(149625);
            return;
          }
        }
        localObject1 = this.dta;
        localObject2 = this.hHA;
        if (localObject2 == null) {
          d.g.b.k.fvU();
        }
        ad.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg bizUsername: %s, template size: %s", new Object[] { localObject1, Integer.valueOf(((ArrayList)localObject2).size()) });
        localObject1 = this.hHm;
      } while (localObject1 == null);
      Object localObject2 = this.dta;
      ArrayList localArrayList = this.hHA;
      if (localArrayList == null) {
        d.g.b.k.fvU();
      }
      ((e)localObject1).a((String)localObject2, (List)localArrayList, this.buffer, this.hHD, (e.b)new f(this));
      AppMethodBeat.o(149625);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class b
      implements DialogInterface.OnClickListener
    {
      b(b.b paramb, int paramInt, SubscribeMsgRequestResult paramSubscribeMsgRequestResult) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(149612);
        if ((this.hHH == 3) || (this.hHH == 1))
        {
          paramDialogInterface = this.hHG.hHE;
          if (paramDialogInterface != null)
          {
            paramDialogInterface.a(false, this.hHI);
            AppMethodBeat.o(149612);
            return;
          }
          AppMethodBeat.o(149612);
          return;
        }
        paramDialogInterface = this.hHG.hHE;
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(this.hHI);
          AppMethodBeat.o(149612);
          return;
        }
        AppMethodBeat.o(149612);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(b.b paramb, int paramInt, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      d(b.b paramb, int paramInt, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$run$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    public static final class e
      implements e.b
    {
      public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(149615);
        d.g.b.k.h(paramString, "bizUsername");
        d.g.b.k.h(paramSubscribeMsgRequestResult, "result");
        ad.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgListByUrl onSuccess bizUsername: %s, size: %d", new Object[] { paramString, Integer.valueOf(paramSubscribeMsgRequestResult.hGg.size()) });
        b.b.a(this.hHG, this.hHG.context, this.hHG.action, paramSubscribeMsgRequestResult);
        AppMethodBeat.o(149615);
      }
      
      public final void i(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(149616);
        d.g.b.k.h(paramString, "errMsg");
        ad.e("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgByUrl onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        b.a locala = this.hHG.hHE;
        if (locala != null)
        {
          locala.a(this.hHG.action, 1, paramInt2, paramString);
          AppMethodBeat.o(149616);
          return;
        }
        AppMethodBeat.o(149616);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$run$2", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    public static final class f
      implements e.b
    {
      public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(149617);
        d.g.b.k.h(paramString, "bizUsername");
        d.g.b.k.h(paramSubscribeMsgRequestResult, "result");
        ad.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg success bizUsername: %s, template size: %d", new Object[] { paramString, Integer.valueOf(paramSubscribeMsgRequestResult.hGg.size()) });
        b.b.a(this.hHG, this.hHG.context, this.hHG.action, paramSubscribeMsgRequestResult);
        AppMethodBeat.o(149617);
      }
      
      public final void i(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(149618);
        d.g.b.k.h(paramString, "errMsg");
        ad.e("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        b.a locala = this.hHG.hHE;
        if (locala != null)
        {
          locala.a(this.hHG.action, 2, paramInt2, paramString);
          AppMethodBeat.o(149618);
          return;
        }
        AppMethodBeat.o(149618);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class g
      implements DialogInterface.OnClickListener
    {
      g(b.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, Context paramContext) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(149619);
        paramDialogInterface = this.hHG.hHE;
        if (paramDialogInterface != null) {
          paramDialogInterface.a(false, this.hHI);
        }
        paramDialogInterface = f.hHV;
        paramDialogInterface = f.AN("name_biz");
        if (paramDialogInterface != null)
        {
          paramDialogInterface.k(this.cjo, this.hHG.dta, this.hHI.appName);
          AppMethodBeat.o(149619);
          return;
        }
        AppMethodBeat.o(149619);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class h
      implements DialogInterface.OnClickListener
    {
      h(b.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(149620);
        paramDialogInterface = this.hHG.hHE;
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(false, this.hHI);
          AppMethodBeat.o(149620);
          return;
        }
        AppMethodBeat.o(149620);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$2", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "onDismiss", "", "onShow", "plugin-comm_release"})
    public static final class i
      implements b.e
    {
      i(com.tencent.mm.msgsubscription.ui.b paramb) {}
      
      public final void onDismiss()
      {
        AppMethodBeat.i(149622);
        b.a locala = this.hHG.hHE;
        if (locala != null)
        {
          locala.aEq();
          AppMethodBeat.o(149622);
          return;
        }
        AppMethodBeat.o(149622);
      }
      
      public final void onShow()
      {
        AppMethodBeat.i(149621);
        b.a locala = this.hHG.hHE;
        if (locala != null)
        {
          locala.a((com.tencent.mm.plugin.appbrand.widget.dialog.k)this.hHJ, b.b.c(this.hHG));
          AppMethodBeat.o(149621);
          return;
        }
        AppMethodBeat.o(149621);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$3", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "onSampleShow", "", "templateId", "", "check", "", "index", "", "plugin-comm_release"})
    public static final class j
      implements com.tencent.mm.msgsubscription.ui.b.a.a
    {
      public final void ar(String paramString, int paramInt)
      {
        AppMethodBeat.i(149623);
        d.g.b.k.h(paramString, "templateId");
        paramString = com.tencent.mm.msgsubscription.b.a.hHk;
        com.tencent.mm.msgsubscription.b.a.pf(paramInt);
        AppMethodBeat.o(149623);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$subscribeMsgRequestDialog$1", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "onEvent", "", "event", "", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "plugin-comm_release"})
    public static final class k
      implements b.d
    {
      k(SubscribeMsgRequestResult paramSubscribeMsgRequestResult, long paramLong) {}
      
      public final void c(int paramInt, List<com.tencent.mm.msgsubscription.ui.b.b> paramList)
      {
        AppMethodBeat.i(149624);
        d.g.b.k.h(paramList, "resultData");
        switch (paramInt)
        {
        }
        do
        {
          AppMethodBeat.o(149624);
          return;
          if (b.b.b(paramInt, paramList, (List)this.hHI.hGg))
          {
            this.hHG.hHA = this.hHI.hGg;
            this.hHG.action = 2;
            b.b.a(this.hHG, this.hHI.buffer);
            localObject = this.hHG;
            SubscribeMsgRequestDialogUiData.a locala = SubscribeMsgRequestDialogUiData.hFY;
            b.b.a((b.b)localObject, SubscribeMsgRequestDialogUiData.a.a(paramInt, j.q((Collection)paramList), false));
            b.b.a(this.hHG, paramInt);
            paramList = b.hHx;
            b.b(this.hHG);
            if (paramInt == 1) {
              paramList = SubscribeMsgRequestDialogUiData.hFY;
            }
            for (paramInt = SubscribeMsgRequestDialogUiData.aEi();; paramInt = SubscribeMsgRequestDialogUiData.aEj())
            {
              paramList = com.tencent.mm.msgsubscription.b.a.hHk;
              com.tencent.mm.msgsubscription.b.a.a(this.hHG.dta, paramInt, (List)this.hHI.hGg, this.hHK);
              AppMethodBeat.o(149624);
              return;
              paramList = SubscribeMsgRequestDialogUiData.hFY;
            }
          }
          paramList = com.tencent.mm.msgsubscription.b.a.hHk;
          paramList = this.hHG.dta;
          Object localObject = SubscribeMsgRequestDialogUiData.hFY;
          com.tencent.mm.msgsubscription.b.a.a(paramList, SubscribeMsgRequestDialogUiData.aEj(), (List)this.hHI.hGg, this.hHK);
          paramList = this.hHG.hHE;
        } while (paramList == null);
        paramList.onCancel();
        AppMethodBeat.o(149624);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.b
 * JD-Core Version:    0.7.0.1
 */