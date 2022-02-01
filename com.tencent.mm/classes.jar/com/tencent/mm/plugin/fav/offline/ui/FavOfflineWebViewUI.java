package com.tencent.mm.plugin.fav.offline.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.plugin.fav.offline.b.a;
import com.tencent.mm.plugin.fav.offline.b.b;
import com.tencent.mm.plugin.fav.offline.b.c;
import com.tencent.mm.plugin.fav.offline.b.d;
import com.tencent.mm.plugin.fav.offline.b.e;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import com.tencent.xweb.ag;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FavOfflineWebViewUI
  extends MMActivity
{
  private com.tencent.mm.plugin.fav.offline.b.a Afs;
  private MMWebView Aft;
  private FrameLayout Afu;
  private g Afv;
  private a Afw;
  private boolean lBW = true;
  private String mUrl;
  
  public int getLayoutId()
  {
    return b.c.Afb;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73584);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(b.a.white));
    setBackGroundColorResource(b.a.white);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73575);
        FavOfflineWebViewUI.this.finish();
        AppMethodBeat.o(73575);
        return true;
      }
    }, b.d.actionbar_icon_dark_close);
    addIconOptionMenu(0, b.d.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73580);
        Log.d("MicroMsg.offline.FavOfflineWebViewUI", "onMenuItemClick click");
        paramAnonymousMenuItem = new f(FavOfflineWebViewUI.this.getContext(), 0, false);
        paramAnonymousMenuItem.Vtg = new u.g()
        {
          public final void onCreateMMMenu(s paramAnonymous2s)
          {
            AppMethodBeat.i(73576);
            paramAnonymous2s.a(2, FavOfflineWebViewUI.this.getString(b.e.Afe), b.d.icons_filled_share, FavOfflineWebViewUI.this.getResources().getColor(b.a.Brand), false);
            paramAnonymous2s.a(3, FavOfflineWebViewUI.this.getString(b.e.Aff), b.d.bottomsheet_icon_moment, false);
            AppMethodBeat.o(73576);
          }
        };
        paramAnonymousMenuItem.GAz = new u.g()
        {
          public final void onCreateMMMenu(s paramAnonymous2s)
          {
            AppMethodBeat.i(73577);
            paramAnonymous2s.bx(0, b.e.Afd, b.d.bottomsheet_icon_addtag);
            paramAnonymous2s.bx(1, b.e.Afc, b.d.bottomsheet_icon_del);
            AppMethodBeat.o(73577);
          }
        };
        paramAnonymousMenuItem.GAC = new u.i()
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
              c.d(FavOfflineWebViewUI.this, ".ui.transmit.SelectConversationUI", localIntent, 1);
              AppMethodBeat.o(73578);
              return;
            }
            Object localObject = "";
            String str;
            if (FavOfflineWebViewUI.a(FavOfflineWebViewUI.this).field_favProto.ZAj != null)
            {
              localObject = FavOfflineWebViewUI.a(FavOfflineWebViewUI.this).field_favProto.ZAj;
              paramAnonymous2MenuItem = FavOfflineWebViewUI.a(FavOfflineWebViewUI.this).field_favProto.title;
              if (!Util.isNullOrNil(((ask)localObject).title)) {
                paramAnonymous2MenuItem = ((ask)localObject).title;
              }
              str = ((ask)localObject).thumbUrl;
              localObject = paramAnonymous2MenuItem;
            }
            for (paramAnonymous2MenuItem = str;; paramAnonymous2MenuItem = "")
            {
              localIntent.putExtra("Ksnsupload_link", FavOfflineWebViewUI.b(FavOfflineWebViewUI.this));
              localIntent.putExtra("Ksnsupload_title", (String)localObject);
              localIntent.putExtra("Ksnsupload_imgurl", paramAnonymous2MenuItem);
              localIntent.putExtra("Ksnsupload_imgbuf", com.tencent.mm.vfs.y.bi(com.tencent.mm.plugin.fav.a.b.a(com.tencent.mm.plugin.fav.a.b.c(FavOfflineWebViewUI.a(FavOfflineWebViewUI.this))), 0, -1));
              localIntent.putExtra("Ksnsupload_type", 1);
              localIntent.putExtra("need_result", true);
              c.a(FavOfflineWebViewUI.this, "sns", ".ui.SnsUploadUI", localIntent, 2, false);
              break;
            }
          }
        };
        paramAnonymousMenuItem.agem = new u.i()
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
        paramAnonymousMenuItem.dDn();
        AppMethodBeat.o(73580);
        return true;
      }
    });
    this.Aft = MMWebView.a.b(this, getContentView(), b.b.webview);
    this.Afu = ((FrameLayout)findViewById(b.b.Afa));
    this.Aft.getSettings().setJavaScriptEnabled(true);
    this.Aft.getSettings().kfL();
    this.Aft.addJavascriptInterface(this.Afw, "java_obj");
    this.Aft.setWebViewClient(new ag()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        return true;
      }
      
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(73581);
        Log.d("MicroMsg.offline.FavOfflineWebViewUI", "onPageFinished URL:".concat(String.valueOf(paramAnonymousString)));
        if ((paramAnonymousWebView != null) && (FavOfflineWebViewUI.c(FavOfflineWebViewUI.this)))
        {
          paramAnonymousWebView.evaluateJavascript("javascript:function setJsAcion(){document.querySelectorAll('img').forEach(function(img){img.addEventListener('click',function(){window.java_obj.doImgPreview(img.src)}) });var div = document.createElement('div');\ndiv.innerHTML = '<div style=\"padding: 8px 16px 4px;background: #FFFFFF;\"><div style=\"padding:12px 16px;background: #F7F7F7;-webkit-border-radius:4px;border-radius:4px;color: rgba(0,0,0,.5);font-size:17px;line-height:1.4;\">当前网络不可用，正在使用离线模式阅读</div></div>';\nvar parentNode = document.getElementById('js_article');\nvar oldNode = document.getElementsByClassName('rich_media_inner')[0];\nparentNode.insertBefore(div.firstChild, oldNode);}", null);
          paramAnonymousWebView.evaluateJavascript("javascript:setJsAcion()", null);
          FavOfflineWebViewUI.d(FavOfflineWebViewUI.this);
        }
        AppMethodBeat.o(73581);
      }
    });
    Object localObject = new u(com.tencent.mm.vfs.y.n(com.tencent.mm.vfs.y.n(this.Afs.field_path, false), false));
    localObject = FileProviderHelper.getUriForFile(getContext(), (u)localObject).toString();
    Log.d("MicroMsg.offline.FavOfflineWebViewUI", "basePath:%s", new Object[] { localObject });
    try
    {
      this.Aft.loadDataWithBaseURL((String)localObject, com.tencent.mm.vfs.y.bEn(this.Afs.field_path), "text/html", "utf-8", null);
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
      Log.d("MicroMsg.offline.FavOfflineWebViewUI", "select %s for sending", new Object[] { str });
      if (Util.isNullOrNil(str))
      {
        AppMethodBeat.o(73585);
        return;
      }
      if (new com.tencent.mm.plugin.fav.a.k().u(this.Afv))
      {
        com.tencent.mm.ui.base.k.cZ(getApplicationContext(), getString(b.e.favorite_retransmit_tip));
        AppMethodBeat.o(73585);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(this.Afv);
      final w localw = com.tencent.mm.ui.base.k.a(getContext(), getString(b.e.favorite_forward_tips), false, null);
      l.a(getContext(), str, paramIntent.getStringExtra("custom_send_text"), localLinkedList, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(73582);
          localw.dismiss();
          com.tencent.mm.ui.widget.snackbar.b.u(FavOfflineWebViewUI.this, FavOfflineWebViewUI.this.getString(b.e.fav_finish_sent));
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
      Log.e("MicroMsg.offline.FavOfflineWebViewUI", "favLocalId is 0l!!!");
      finish();
      AppMethodBeat.o(73583);
      return;
    }
    this.Afs = ((PluginFavOffline)h.az(PluginFavOffline.class)).getFavOfflineStorage().aus(this.mUrl);
    if (this.Afs == null)
    {
      Log.e("MicroMsg.offline.FavOfflineWebViewUI", "favOffline is null!!!");
      finish();
      AppMethodBeat.o(73583);
      return;
    }
    this.Afv = ((ah)h.az(ah.class)).getFavItemInfoStorage().mK(l);
    if (this.Afv == null)
    {
      Log.e("MicroMsg.offline.FavOfflineWebViewUI", "curInfo is null!!!");
      finish();
      AppMethodBeat.o(73583);
      return;
    }
    Log.i("MicroMsg.offline.FavOfflineWebViewUI", "mUrl : %s", new Object[] { this.mUrl });
    if (Util.isNullOrNil(this.mUrl))
    {
      Log.e("MicroMsg.offline.FavOfflineWebViewUI", "mUrl is null!!!");
      finish();
      AppMethodBeat.o(73583);
      return;
    }
    this.Afw = new a(this, this.Afs);
    initView();
    AppMethodBeat.o(73583);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.offline.ui.FavOfflineWebViewUI
 * JD-Core Version:    0.7.0.1
 */