package com.tencent.mm.plugin.fav.offline.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.vfs.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.y;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FavOfflineWebViewUI
  extends MMActivity
{
  private boolean frM = true;
  private String mUrl;
  private com.tencent.mm.plugin.fav.offline.b.a qcn;
  private MMWebView qco;
  private FrameLayout qcp;
  private com.tencent.mm.plugin.fav.a.g qcq;
  private a qcr;
  
  public int getLayoutId()
  {
    return 2131493971;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73584);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    setBackGroundColorResource(2131101179);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73575);
        FavOfflineWebViewUI.this.finish();
        AppMethodBeat.o(73575);
        return true;
      }
    }, 2131689492);
    addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73580);
        ad.d("MicroMsg.offline.FavOfflineWebViewUI", "onMenuItemClick click");
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(FavOfflineWebViewUI.this.getContext(), 0, false);
        paramAnonymousMenuItem.HrX = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(73576);
            paramAnonymous2l.a(2, FavOfflineWebViewUI.this.getString(2131758838), 2131690478, FavOfflineWebViewUI.this.getResources().getColor(2131099699), false);
            paramAnonymous2l.a(3, FavOfflineWebViewUI.this.getString(2131758839), 2131689817, false);
            AppMethodBeat.o(73576);
          }
        };
        paramAnonymousMenuItem.HEP = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(73577);
            paramAnonymous2l.aI(0, 2131758837, 2131689794);
            paramAnonymous2l.aI(1, 2131758836, 2131689802);
            AppMethodBeat.o(73577);
          }
        };
        paramAnonymousMenuItem.HrY = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(73578);
            Intent localIntent = new Intent();
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              AppMethodBeat.o(73578);
              return;
            case 2: 
              new LinkedList().add(FavOfflineWebViewUI.a(FavOfflineWebViewUI.this));
              localIntent.putExtra("Select_Conv_Type", 3);
              localIntent.putExtra("scene_from", 1);
              localIntent.putExtra("mutil_select_is_ret", true);
              localIntent.putExtra("select_fav_local_id", FavOfflineWebViewUI.a(FavOfflineWebViewUI.this).field_localId);
              localIntent.putExtra("Retr_Msg_Type", 2);
              d.c(FavOfflineWebViewUI.this, ".ui.transmit.SelectConversationUI", localIntent, 1);
              AppMethodBeat.o(73578);
              return;
            }
            Object localObject = "";
            String str;
            if (FavOfflineWebViewUI.a(FavOfflineWebViewUI.this).field_favProto.DhE != null)
            {
              localObject = FavOfflineWebViewUI.a(FavOfflineWebViewUI.this).field_favProto.DhE;
              paramAnonymous2MenuItem = FavOfflineWebViewUI.a(FavOfflineWebViewUI.this).field_favProto.title;
              if (!bt.isNullOrNil(((ahd)localObject).title)) {
                paramAnonymous2MenuItem = ((ahd)localObject).title;
              }
              str = ((ahd)localObject).thumbUrl;
              localObject = paramAnonymous2MenuItem;
            }
            for (paramAnonymous2MenuItem = str;; paramAnonymous2MenuItem = "")
            {
              localIntent.putExtra("Ksnsupload_link", FavOfflineWebViewUI.b(FavOfflineWebViewUI.this));
              localIntent.putExtra("Ksnsupload_title", (String)localObject);
              localIntent.putExtra("Ksnsupload_imgurl", paramAnonymous2MenuItem);
              localIntent.putExtra("Ksnsupload_imgbuf", i.aR(com.tencent.mm.plugin.fav.a.b.a(com.tencent.mm.plugin.fav.a.b.c(FavOfflineWebViewUI.a(FavOfflineWebViewUI.this))), 0, -1));
              localIntent.putExtra("Ksnsupload_type", 1);
              localIntent.putExtra("need_result", true);
              d.a(FavOfflineWebViewUI.this, "sns", ".ui.SnsUploadUI", localIntent, 2, false);
              break;
            }
          }
        };
        paramAnonymousMenuItem.HER = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(73579);
            Intent localIntent = new Intent();
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(73579);
              return;
              localIntent.putExtra("key_fav_scene", 4);
              localIntent.putExtra("key_fav_item_id", FavOfflineWebViewUI.a(FavOfflineWebViewUI.this).field_localId);
              com.tencent.mm.plugin.fav.a.b.b(FavOfflineWebViewUI.this.getContext(), ".ui.FavTagEditUI", localIntent);
              AppMethodBeat.o(73579);
              return;
              com.tencent.mm.plugin.fav.a.b.a(FavOfflineWebViewUI.a(FavOfflineWebViewUI.this), null);
              FavOfflineWebViewUI.this.finish();
            }
          }
        };
        paramAnonymousMenuItem.csG();
        AppMethodBeat.o(73580);
        return true;
      }
    });
    this.qco = MMWebView.a.a(this, getContentView(), 2131306909);
    this.qcp = ((FrameLayout)findViewById(2131300710));
    this.qco.getSettings().setJavaScriptEnabled(true);
    this.qco.getSettings().fqX();
    this.qco.getSettings().frb();
    this.qco.getSettings().frc();
    this.qco.addJavascriptInterface(this.qcr, "java_obj");
    this.qco.setWebViewClient(new ab()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        return true;
      }
      
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(73581);
        ad.d("MicroMsg.offline.FavOfflineWebViewUI", "onPageFinished URL:".concat(String.valueOf(paramAnonymousString)));
        if ((paramAnonymousWebView != null) && (FavOfflineWebViewUI.c(FavOfflineWebViewUI.this)))
        {
          paramAnonymousWebView.evaluateJavascript("javascript:function setJsAcion(){document.querySelectorAll('img').forEach(function(img){img.addEventListener('click',function(){window.java_obj.doImgPreview(img.src)}) });var div = document.createElement('div');\ndiv.innerHTML = '<div style=\"padding: 8px 16px 4px;background: #FFFFFF;\"><div style=\"padding:12px 16px;background: #F7F7F7;-webkit-border-radius:4px;border-radius:4px;color: rgba(0,0,0,.5);font-size:17px;line-height:1.4;\">当前网络不可用，正在使用离线模式阅读</div></div>';\nvar parentNode = document.getElementById('js_article');\nvar oldNode = document.getElementsByClassName('rich_media_inner')[0];\nparentNode.insertBefore(div.firstChild, oldNode);}", null);
          paramAnonymousWebView.evaluateJavascript("javascript:setJsAcion()", null);
          FavOfflineWebViewUI.d(FavOfflineWebViewUI.this);
        }
        AppMethodBeat.o(73581);
      }
    });
    Object localObject = new com.tencent.mm.vfs.e(i.k(i.k(this.qcn.field_path, false), false));
    localObject = m.a(getContext(), (com.tencent.mm.vfs.e)localObject).toString();
    ad.d("MicroMsg.offline.FavOfflineWebViewUI", "basePath:%s", new Object[] { localObject });
    try
    {
      this.qco.loadDataWithBaseURL((String)localObject, i.aMP(this.qcn.field_path), "text/html", "utf-8", null);
      AppMethodBeat.o(73584);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(73584);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(73585);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(73585);
      return;
      String str = paramIntent.getStringExtra("Select_Conv_User");
      ad.d("MicroMsg.offline.FavOfflineWebViewUI", "select %s for sending", new Object[] { str });
      if (bt.isNullOrNil(str))
      {
        AppMethodBeat.o(73585);
        return;
      }
      if (new k().u(this.qcq))
      {
        h.cf(getApplicationContext(), getString(2131758987));
        AppMethodBeat.o(73585);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(this.qcq);
      final p localp = h.b(getContext(), getString(2131758906), false, null);
      com.tencent.mm.plugin.fav.ui.l.a(getContext(), str, paramIntent.getStringExtra("custom_send_text"), localLinkedList, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(73582);
          localp.dismiss();
          com.tencent.mm.ui.widget.snackbar.b.n(FavOfflineWebViewUI.this, FavOfflineWebViewUI.this.getString(2131758834));
          AppMethodBeat.o(73582);
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73583);
    super.onCreate(paramBundle);
    this.mUrl = getIntent().getStringExtra("key_path");
    long l = getIntent().getLongExtra("key_detail_info_id", 0L);
    if (l == 0L)
    {
      ad.e("MicroMsg.offline.FavOfflineWebViewUI", "favLocalId is 0l!!!");
      finish();
      AppMethodBeat.o(73583);
      return;
    }
    this.qcn = ((PluginFavOffline)com.tencent.mm.kernel.g.ad(PluginFavOffline.class)).getFavOfflineStorage().Yu(this.mUrl);
    if (this.qcn == null)
    {
      ad.e("MicroMsg.offline.FavOfflineWebViewUI", "favOffline is null!!!");
      finish();
      AppMethodBeat.o(73583);
      return;
    }
    this.qcq = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(l);
    if (this.qcq == null)
    {
      ad.e("MicroMsg.offline.FavOfflineWebViewUI", "curInfo is null!!!");
      finish();
      AppMethodBeat.o(73583);
      return;
    }
    ad.i("MicroMsg.offline.FavOfflineWebViewUI", "mUrl : %s", new Object[] { this.mUrl });
    if (bt.isNullOrNil(this.mUrl))
    {
      ad.e("MicroMsg.offline.FavOfflineWebViewUI", "mUrl is null!!!");
      finish();
      AppMethodBeat.o(73583);
      return;
    }
    this.qcr = new a(this, this.qcn);
    initView();
    AppMethodBeat.o(73583);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.offline.ui.FavOfflineWebViewUI
 * JD-Core Version:    0.7.0.1
 */