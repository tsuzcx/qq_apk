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
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.z;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FavOfflineWebViewUI
  extends MMActivity
{
  private boolean gvP = true;
  private String mUrl;
  private com.tencent.mm.plugin.fav.offline.b.a tcM;
  private MMWebView tcN;
  private FrameLayout tcO;
  private com.tencent.mm.plugin.fav.a.g tcP;
  private a tcQ;
  
  public int getLayoutId()
  {
    return 2131494141;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73584);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    setBackGroundColorResource(2131101424);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73575);
        FavOfflineWebViewUI.this.finish();
        AppMethodBeat.o(73575);
        return true;
      }
    }, 2131689494);
    addIconOptionMenu(0, 2131689495, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73580);
        Log.d("MicroMsg.offline.FavOfflineWebViewUI", "onMenuItemClick click");
        paramAnonymousMenuItem = new e(FavOfflineWebViewUI.this.getContext(), 0, false);
        paramAnonymousMenuItem.HLX = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymous2m)
          {
            AppMethodBeat.i(73576);
            paramAnonymous2m.a(2, FavOfflineWebViewUI.this.getString(2131759161), 2131690674, FavOfflineWebViewUI.this.getResources().getColor(2131099710), false);
            paramAnonymous2m.a(3, FavOfflineWebViewUI.this.getString(2131759162), 2131689830, false);
            AppMethodBeat.o(73576);
          }
        };
        paramAnonymousMenuItem.QNH = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymous2m)
          {
            AppMethodBeat.i(73577);
            paramAnonymous2m.aS(0, 2131759160, 2131689805);
            paramAnonymous2m.aS(1, 2131759159, 2131689814);
            AppMethodBeat.o(73577);
          }
        };
        paramAnonymousMenuItem.HLY = new o.g()
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
              c.c(FavOfflineWebViewUI.this, ".ui.transmit.SelectConversationUI", localIntent, 1);
              AppMethodBeat.o(73578);
              return;
            }
            Object localObject = "";
            String str;
            if (FavOfflineWebViewUI.a(FavOfflineWebViewUI.this).field_favProto.LwS != null)
            {
              localObject = FavOfflineWebViewUI.a(FavOfflineWebViewUI.this).field_favProto.LwS;
              paramAnonymous2MenuItem = FavOfflineWebViewUI.a(FavOfflineWebViewUI.this).field_favProto.title;
              if (!Util.isNullOrNil(((anq)localObject).title)) {
                paramAnonymous2MenuItem = ((anq)localObject).title;
              }
              str = ((anq)localObject).thumbUrl;
              localObject = paramAnonymous2MenuItem;
            }
            for (paramAnonymous2MenuItem = str;; paramAnonymous2MenuItem = "")
            {
              localIntent.putExtra("Ksnsupload_link", FavOfflineWebViewUI.b(FavOfflineWebViewUI.this));
              localIntent.putExtra("Ksnsupload_title", (String)localObject);
              localIntent.putExtra("Ksnsupload_imgurl", paramAnonymous2MenuItem);
              localIntent.putExtra("Ksnsupload_imgbuf", s.aW(com.tencent.mm.plugin.fav.a.b.a(com.tencent.mm.plugin.fav.a.b.c(FavOfflineWebViewUI.a(FavOfflineWebViewUI.this))), 0, -1));
              localIntent.putExtra("Ksnsupload_type", 1);
              localIntent.putExtra("need_result", true);
              c.a(FavOfflineWebViewUI.this, "sns", ".ui.SnsUploadUI", localIntent, 2, false);
              break;
            }
          }
        };
        paramAnonymousMenuItem.QNK = new o.g()
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
        paramAnonymousMenuItem.dGm();
        AppMethodBeat.o(73580);
        return true;
      }
    });
    this.tcN = MMWebView.a.a(this, getContentView(), 2131310382);
    this.tcO = ((FrameLayout)findViewById(2131302282));
    this.tcN.getSettings().setJavaScriptEnabled(true);
    this.tcN.getSettings().hsL();
    this.tcN.getSettings().hsP();
    this.tcN.getSettings().hsQ();
    this.tcN.addJavascriptInterface(this.tcQ, "java_obj");
    this.tcN.setWebViewClient(new ac()
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
    Object localObject = new o(s.k(s.k(this.tcM.field_path, false), false));
    localObject = FileProviderHelper.getUriForFile(getContext(), (o)localObject).toString();
    Log.d("MicroMsg.offline.FavOfflineWebViewUI", "basePath:%s", new Object[] { localObject });
    try
    {
      this.tcN.loadDataWithBaseURL((String)localObject, s.boY(this.tcM.field_path), "text/html", "utf-8", null);
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
      if (new k().u(this.tcP))
      {
        h.cD(getApplicationContext(), getString(2131759312));
        AppMethodBeat.o(73585);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(this.tcP);
      final q localq = h.a(getContext(), getString(2131759230), false, null);
      l.a(getContext(), str, paramIntent.getStringExtra("custom_send_text"), localLinkedList, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(73582);
          localq.dismiss();
          com.tencent.mm.ui.widget.snackbar.b.r(FavOfflineWebViewUI.this, FavOfflineWebViewUI.this.getString(2131759157));
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
    this.tcM = ((PluginFavOffline)com.tencent.mm.kernel.g.ah(PluginFavOffline.class)).getFavOfflineStorage().ask(this.mUrl);
    if (this.tcM == null)
    {
      Log.e("MicroMsg.offline.FavOfflineWebViewUI", "favOffline is null!!!");
      finish();
      AppMethodBeat.o(73583);
      return;
    }
    this.tcP = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(l);
    if (this.tcP == null)
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
    this.tcQ = new a(this, this.tcM);
    initView();
    AppMethodBeat.o(73583);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.offline.ui.FavOfflineWebViewUI
 * JD-Core Version:    0.7.0.1
 */