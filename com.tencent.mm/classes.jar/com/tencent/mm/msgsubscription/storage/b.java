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
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController;", "Lcom/tencent/mm/msgsubscription/storage/IBrandSubscribeMsgRequestController;", "()V", "TAG", "", "getSubscribeMsgList", "", "requestTask", "Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "subscribeMsgList", "SubscribeMsgRequestCallback", "SubscribeMsgRequestTask", "plugin-comm_release"})
public final class b
{
  public static final b iBt;
  
  static
  {
    AppMethodBeat.i(149633);
    iBt = new b();
    AppMethodBeat.o(149633);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(149631);
    p.h(paramb, "requestTask");
    paramb.run();
    AppMethodBeat.o(149631);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(149632);
    p.h(paramb, "requestTask");
    paramb.run();
    AppMethodBeat.o(149632);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "", "dismissProgressDialog", "", "onCancel", "onDismissDialog", "onError", "action", "", "errType", "errCode", "errMsg", "", "onGetSubscribeListSuccess", "showDialog", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onShowDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "containerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "onSubscribeMsgSuccess", "Companion", "plugin-comm_release"})
  public static abstract interface a
  {
    public static final b.a.a iBu = b.a.a.iBv;
    
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, String paramString);
    
    public abstract void a(SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void a(k paramk, com.tencent.mm.plugin.appbrand.widget.dialog.e parame);
    
    public abstract void a(boolean paramBoolean, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void aOr();
    
    public abstract void aOs();
    
    public abstract void onCancel();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "", "context", "Landroid/content/Context;", "action", "", "bizUsername", "", "subscribeUrl", "content", "requestCallback", "Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;)V", "getAction", "()I", "setAction", "(I)V", "getBizUsername", "()Ljava/lang/String;", "buffer", "", "getContent", "getContext", "()Landroid/content/Context;", "dataLoader", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "mDialogContainerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "mEvent", "getRequestCallback", "()Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "subscribeMsgTmpItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "getSubscribeMsgTmpItems", "()Ljava/util/ArrayList;", "setSubscribeMsgTmpItems", "(Ljava/util/ArrayList;)V", "getSubscribeUrl", "uiData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "applyUserAction", "", "event", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "", "dispatchSuccessResult", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "run", "showAlertDialog", "title", "okOnClickListener", "Landroid/content/DialogInterface$OnClickListener;", "showSettingPageAlert", "showSubscribeRequestDialog", "timestamp", "", "showToast", "msg", "callback", "Lkotlin/Function0;", "Companion", "plugin-comm_release"})
  public static final class b
  {
    public static final a iBB;
    int action;
    private byte[] buffer;
    private final String content;
    final Context context;
    final String dCB;
    private final String iAS;
    final b.a iBA;
    private e iBi;
    ArrayList<SubscribeMsgTmpItem> iBw;
    private com.tencent.mm.plugin.appbrand.widget.dialog.e iBx;
    private int iBy;
    private SubscribeMsgRequestDialogUiData iBz;
    
    static
    {
      AppMethodBeat.i(149628);
      iBB = new a((byte)0);
      AppMethodBeat.o(149628);
    }
    
    public b(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, b.a parama)
    {
      AppMethodBeat.i(149627);
      this.context = paramContext;
      this.action = paramInt;
      this.dCB = paramString1;
      this.iAS = paramString2;
      this.content = paramString3;
      this.iBA = parama;
      this.iBy = -1;
      this.buffer = new byte[] { 0 };
      paramContext = f.iBR;
      paramContext = f.Ig("name_biz");
      if (paramContext != null) {
        this.iBi = new e(paramContext.aOt());
      }
      AppMethodBeat.o(149627);
    }
    
    private final void g(String paramString, d.g.a.a<z> parama)
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
        if (((CharSequence)this.iAS).length() == 0) {
          i = 1;
        }
        while (i != 0)
        {
          localObject1 = this.iBA;
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
        ad.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgByUrl bizUsername: %s, url: %s", new Object[] { this.dCB, this.iAS });
        localObject1 = this.iBi;
        if (localObject1 != null)
        {
          ((e)localObject1).a(this.dCB, this.iAS, (e.b)new e(this));
          AppMethodBeat.o(149625);
          return;
        }
        AppMethodBeat.o(149625);
        return;
        localObject1 = (Collection)this.iBw;
        if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
          i = 1;
        }
        while (i != 0)
        {
          localObject1 = this.iBA;
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
        localObject1 = this.dCB;
        localObject2 = this.iBw;
        if (localObject2 == null) {
          p.gfZ();
        }
        ad.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg bizUsername: %s, template size: %s", new Object[] { localObject1, Integer.valueOf(((ArrayList)localObject2).size()) });
        localObject1 = this.iBi;
      } while (localObject1 == null);
      Object localObject2 = this.dCB;
      ArrayList localArrayList = this.iBw;
      if (localArrayList == null) {
        p.gfZ();
      }
      ((e)localObject1).a((String)localObject2, (List)localArrayList, this.buffer, this.iBz, (e.b)new f(this));
      AppMethodBeat.o(149625);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$Companion;", "", "()V", "ACTION_FINISHED", "", "ACTION_GET_AND_SUBSCRIBE", "ACTION_GET_SUBSCRIBE_MSG_LIST", "ACTION_SUBSCRIBE_MSG", "Action", "plugin-comm_release"})
    public static final class a {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class b
      implements DialogInterface.OnClickListener
    {
      b(b.b paramb, int paramInt, SubscribeMsgRequestResult paramSubscribeMsgRequestResult) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(149612);
        if ((this.iBD == 3) || (this.iBD == 1))
        {
          paramDialogInterface = this.iBC.iBA;
          if (paramDialogInterface != null)
          {
            paramDialogInterface.a(false, this.iBE);
            AppMethodBeat.o(149612);
            return;
          }
          AppMethodBeat.o(149612);
          return;
        }
        paramDialogInterface = this.iBC.iBA;
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(this.iBE);
          AppMethodBeat.o(149612);
          return;
        }
        AppMethodBeat.o(149612);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<z>
    {
      c(b.b paramb, int paramInt, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements d.g.a.a<z>
    {
      d(b.b paramb, int paramInt, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$run$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    public static final class e
      implements e.b
    {
      public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(149615);
        p.h(paramString, "bizUsername");
        p.h(paramSubscribeMsgRequestResult, "result");
        ad.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgListByUrl onSuccess bizUsername: %s, size: %d", new Object[] { paramString, Integer.valueOf(paramSubscribeMsgRequestResult.iAc.size()) });
        b.b.a(this.iBC, this.iBC.context, this.iBC.action, paramSubscribeMsgRequestResult);
        AppMethodBeat.o(149615);
      }
      
      public final void i(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(149616);
        p.h(paramString, "errMsg");
        ad.e("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgByUrl onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        b.a locala = this.iBC.iBA;
        if (locala != null)
        {
          locala.a(this.iBC.action, 1, paramInt2, paramString);
          AppMethodBeat.o(149616);
          return;
        }
        AppMethodBeat.o(149616);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$run$2", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    public static final class f
      implements e.b
    {
      public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(149617);
        p.h(paramString, "bizUsername");
        p.h(paramSubscribeMsgRequestResult, "result");
        ad.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg success bizUsername: %s, template size: %d", new Object[] { paramString, Integer.valueOf(paramSubscribeMsgRequestResult.iAc.size()) });
        b.b.a(this.iBC, this.iBC.context, this.iBC.action, paramSubscribeMsgRequestResult);
        AppMethodBeat.o(149617);
      }
      
      public final void i(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(149618);
        p.h(paramString, "errMsg");
        ad.e("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        b.a locala = this.iBC.iBA;
        if (locala != null)
        {
          locala.a(this.iBC.action, 2, paramInt2, paramString);
          AppMethodBeat.o(149618);
          return;
        }
        AppMethodBeat.o(149618);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class g
      implements DialogInterface.OnClickListener
    {
      g(b.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, Context paramContext) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(149619);
        paramDialogInterface = this.iBC.iBA;
        if (paramDialogInterface != null) {
          paramDialogInterface.a(false, this.iBE);
        }
        paramDialogInterface = f.iBR;
        paramDialogInterface = f.Ig("name_biz");
        if (paramDialogInterface != null)
        {
          paramDialogInterface.k(this.cqB, this.iBC.dCB, this.iBE.appName);
          AppMethodBeat.o(149619);
          return;
        }
        AppMethodBeat.o(149619);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class h
      implements DialogInterface.OnClickListener
    {
      h(b.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(149620);
        paramDialogInterface = this.iBC.iBA;
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(false, this.iBE);
          AppMethodBeat.o(149620);
          return;
        }
        AppMethodBeat.o(149620);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$2", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "onDismiss", "", "onShow", "plugin-comm_release"})
    public static final class i
      implements b.e
    {
      i(com.tencent.mm.msgsubscription.ui.b paramb) {}
      
      public final void onDismiss()
      {
        AppMethodBeat.i(149622);
        b.a locala = this.iBC.iBA;
        if (locala != null)
        {
          locala.aOr();
          AppMethodBeat.o(149622);
          return;
        }
        AppMethodBeat.o(149622);
      }
      
      public final void onShow()
      {
        AppMethodBeat.i(149621);
        b.a locala = this.iBC.iBA;
        if (locala != null)
        {
          locala.a((k)this.iBF, b.b.c(this.iBC));
          AppMethodBeat.o(149621);
          return;
        }
        AppMethodBeat.o(149621);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$3", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "onSampleShow", "", "templateId", "", "check", "", "index", "", "plugin-comm_release"})
    public static final class j
      implements com.tencent.mm.msgsubscription.ui.b.a.a
    {
      public final void ax(String paramString, int paramInt)
      {
        AppMethodBeat.i(149623);
        p.h(paramString, "templateId");
        paramString = com.tencent.mm.msgsubscription.b.a.iBg;
        com.tencent.mm.msgsubscription.b.a.qw(paramInt);
        AppMethodBeat.o(149623);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/storage/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$subscribeMsgRequestDialog$1", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "onEvent", "", "event", "", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "plugin-comm_release"})
    public static final class k
      implements b.d
    {
      k(SubscribeMsgRequestResult paramSubscribeMsgRequestResult, long paramLong) {}
      
      public final void c(int paramInt, List<com.tencent.mm.msgsubscription.ui.b.b> paramList)
      {
        AppMethodBeat.i(149624);
        p.h(paramList, "resultData");
        switch (paramInt)
        {
        }
        do
        {
          AppMethodBeat.o(149624);
          return;
          if (b.b.b(paramInt, paramList, (List)this.iBE.iAc))
          {
            this.iBC.iBw = this.iBE.iAc;
            this.iBC.action = 2;
            b.b.a(this.iBC, this.iBE.buffer);
            localObject = this.iBC;
            SubscribeMsgRequestDialogUiData.a locala = SubscribeMsgRequestDialogUiData.izU;
            b.b.a((b.b)localObject, SubscribeMsgRequestDialogUiData.a.a(paramInt, j.s((Collection)paramList), false));
            b.b.a(this.iBC, paramInt);
            paramList = b.iBt;
            b.b(this.iBC);
            if (paramInt == 1) {
              paramList = SubscribeMsgRequestDialogUiData.izU;
            }
            for (paramInt = SubscribeMsgRequestDialogUiData.aOi();; paramInt = SubscribeMsgRequestDialogUiData.aOj())
            {
              paramList = com.tencent.mm.msgsubscription.b.a.iBg;
              com.tencent.mm.msgsubscription.b.a.a(this.iBC.dCB, paramInt, (List)this.iBE.iAc, this.iBG);
              AppMethodBeat.o(149624);
              return;
              paramList = SubscribeMsgRequestDialogUiData.izU;
            }
          }
          paramList = com.tencent.mm.msgsubscription.b.a.iBg;
          paramList = this.iBC.dCB;
          Object localObject = SubscribeMsgRequestDialogUiData.izU;
          com.tencent.mm.msgsubscription.b.a.a(paramList, SubscribeMsgRequestDialogUiData.aOj(), (List)this.iBE.iAc, this.iBG);
          paramList = this.iBC.iBA;
        } while (paramList == null);
        paramList.onCancel();
        AppMethodBeat.o(149624);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.b
 * JD-Core Version:    0.7.0.1
 */