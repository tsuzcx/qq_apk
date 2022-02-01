package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.yn;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.g;
import com.tencent.mm.plugin.finder.utils.g.a;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.component.UIComponent;
import d.a.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDebugUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "MENU_CHECK_RELEATED_ID", "", "getMENU_CHECK_RELEATED_ID", "()I", "MENU_CHECK_VIDEO", "getMENU_CHECK_VIDEO", "MENU_COPY_ID", "getMENU_COPY_ID", "MENU_FORWARD_VIDEO", "getMENU_FORWARD_VIDEO", "MENU_INFO_ID", "getMENU_INFO_ID", "createDialog", "", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "createDialogInfo", "txt", "", "Companion", "plugin-finder_release"})
public final class FinderDebugUIC
  extends UIComponent
{
  public static final a LhK;
  public static final String TAG = "MicroMsg.FinderDebugUIC";
  final int LhF;
  final int LhG;
  final int LhH;
  final int LhI;
  final int LhJ;
  
  static
  {
    AppMethodBeat.i(200361);
    LhK = new a((byte)0);
    TAG = "MicroMsg.FinderDebugUIC";
    AppMethodBeat.o(200361);
  }
  
  public FinderDebugUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(200360);
    this.LhF = 1;
    this.LhG = 2;
    this.LhH = 3;
    this.LhI = 4;
    this.LhJ = 5;
    AppMethodBeat.o(200360);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDebugUIC$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class b
    implements n.c
  {
    public b(FinderDebugUIC paramFinderDebugUIC, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(200354);
      paraml.a(this.LhL.LhF, (CharSequence)"feed信息", 2131691483);
      paraml.a(this.LhL.LhH, (CharSequence)"强化流检查", 2131689825);
      if (this.LhM)
      {
        paraml.a(this.LhL.LhI, (CharSequence)"VIDEO信息", 2131689797);
        paraml.a(this.LhL.LhJ, (CharSequence)"转发视频文件", 2131689831);
      }
      paraml.a(this.LhL.LhG, (CharSequence)"拷贝feed全量信息", 2131689829);
      AppMethodBeat.o(200354);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  public static final class c
    implements n.d
  {
    public c(FinderDebugUIC paramFinderDebugUIC, Context paramContext, String paramString1, BaseFinderFeed paramBaseFinderFeed, long paramLong, String paramString2, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
    {
      Object localObject1 = null;
      AppMethodBeat.i(200356);
      d.g.b.k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == this.LhL.LhF)
      {
        FinderDebugUIC.ap(this.cjo, this.LhN);
        AppMethodBeat.o(200356);
        return;
      }
      Object localObject2;
      if (paramInt == this.LhL.LhH)
      {
        paramMenuItem = this.cjo;
        localObject1 = new StringBuilder("后台配置:");
        localObject2 = com.tencent.mm.plugin.finder.storage.data.i.KXv;
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.storage.data.i.BT(this.qqO.feedObject.getId())).append(" \n是否触发拉取过:");
        localObject2 = com.tencent.mm.plugin.finder.storage.data.i.KXv;
        if (!com.tencent.mm.plugin.finder.storage.data.i.BU(this.qqt)) {}
        for (boolean bool = true;; bool = false)
        {
          FinderDebugUIC.ap(paramMenuItem, bool);
          AppMethodBeat.o(200356);
          return;
        }
      }
      if (paramInt == this.LhL.LhI)
      {
        paramMenuItem = (bmd)j.iz((List)this.qqO.feedObject.getMediaList());
        if (paramMenuItem != null)
        {
          localObject1 = c.KXF;
          paramMenuItem = c.b(paramMenuItem);
          localObject1 = new StringBuilder("path:").append(paramMenuItem.getPath()).append(" \nsize:").append(bt.mK(com.tencent.mm.vfs.i.aMN(paramMenuItem.getPath()))).append('\n').append("mediaId:").append(paramMenuItem.qCj.mediaId).append('\n').append("url=");
          paramMenuItem = (bmd)j.iz((List)this.qqO.feedObject.getMediaList());
          if (paramMenuItem != null) {}
          for (paramMenuItem = paramMenuItem.url;; paramMenuItem = null)
          {
            paramMenuItem = paramMenuItem;
            FinderDebugUIC.ap(this.cjo, paramMenuItem);
            AppMethodBeat.o(200356);
            return;
          }
        }
        AppMethodBeat.o(200356);
        return;
      }
      if (paramInt == this.LhL.LhJ)
      {
        paramMenuItem = (bmd)j.iz((List)this.qqO.feedObject.getMediaList());
        if (paramMenuItem != null)
        {
          localObject2 = c.KXF;
          localObject2 = c.b(paramMenuItem);
          Object localObject3 = new StringBuilder("path:").append(((com.tencent.mm.plugin.finder.loader.l)localObject2).getPath()).append(" \nsize:").append(bt.mK(com.tencent.mm.vfs.i.aMN(((com.tencent.mm.plugin.finder.loader.l)localObject2).getPath()))).append('\n').append("mediaId:").append(((com.tencent.mm.plugin.finder.loader.l)localObject2).qCj.mediaId).append('\n').append("url=");
          Object localObject4 = (bmd)j.iz((List)this.qqO.feedObject.getMediaList());
          paramMenuItem = (MenuItem)localObject1;
          if (localObject4 != null) {
            paramMenuItem = ((bmd)localObject4).url;
          }
          paramMenuItem = paramMenuItem;
          localObject1 = new Intent();
          localObject4 = new WXFileObject();
          ((WXFileObject)localObject4).setFilePath(((com.tencent.mm.plugin.finder.loader.l)localObject2).getPath());
          localObject3 = new WXMediaMessage();
          ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject4);
          localObject2 = new com.tencent.mm.vfs.e(((com.tencent.mm.plugin.finder.loader.l)localObject2).getPath());
          ((WXMediaMessage)localObject3).title = ((com.tencent.mm.vfs.e)localObject2).getName();
          ((WXMediaMessage)localObject3).description = bt.mK(((com.tencent.mm.vfs.e)localObject2).length());
          ((Intent)localObject1).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject1).putExtra("select_is_ret", true);
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
          localObject2 = this.cjo;
          if (localObject2 == null)
          {
            paramMenuItem = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(200356);
            throw paramMenuItem;
          }
          localObject2 = (MMActivity)localObject2;
          localObject4 = g.qSw;
          d.a((MMActivity)localObject2, ".ui.transmit.SelectConversationUI", (Intent)localObject1, g.a.fVZ(), (MMActivity.a)new a((WXMediaMessage)localObject3, paramMenuItem));
          AppMethodBeat.o(200356);
          return;
        }
        AppMethodBeat.o(200356);
        return;
      }
      if (paramInt == this.LhL.LhG)
      {
        paramMenuItem = aj.getContext().getSystemService("clipboard");
        if (paramMenuItem == null)
        {
          paramMenuItem = new d.v("null cannot be cast to non-null type android.text.ClipboardManager");
          AppMethodBeat.o(200356);
          throw paramMenuItem;
        }
        ((ClipboardManager)paramMenuItem).setText((CharSequence)this.LhO);
        Toast.makeText(this.nGG.getContext(), (CharSequence)("debug info " + this.LhO), 1).show();
      }
      AppMethodBeat.o(200356);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class a
      implements MMActivity.a
    {
      a(WXMediaMessage paramWXMediaMessage, String paramString) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(200355);
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          d.g.b.k.g(paramIntent, "toUsers");
          paramIntent = (CharSequence)paramIntent;
          paramIntent = new d.n.k(",").r(paramIntent, 0);
          Object localObject;
          if (!paramIntent.isEmpty())
          {
            localObject = paramIntent.listIterator(paramIntent.size());
            if (((ListIterator)localObject).hasPrevious()) {
              if (((CharSequence)((ListIterator)localObject).previous()).length() == 0)
              {
                paramInt1 = 1;
                label99:
                if (paramInt1 != 0) {
                  break label158;
                }
              }
            }
          }
          for (paramIntent = j.b((Iterable)paramIntent, ((ListIterator)localObject).nextIndex() + 1);; paramIntent = (List)d.a.v.Jgl)
          {
            paramIntent = ((Collection)paramIntent).toArray(new String[0]);
            if (paramIntent != null) {
              break label170;
            }
            paramIntent = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(200355);
            throw paramIntent;
            paramInt1 = 0;
            break label99;
            label158:
            break;
          }
          label170:
          paramIntent = bt.S((String[])paramIntent);
          d.g.b.k.g(paramIntent, "toUserList");
          paramIntent = ((Iterable)paramIntent).iterator();
          while (paramIntent.hasNext())
          {
            localObject = (String)paramIntent.next();
            yn localyn = new yn();
            localyn.aEh.doG = this.LhP;
            localyn.aEh.username = ((String)localObject);
            localyn.aEh.dxy = 4;
            localyn.aEh.aSn = paramMenuItem;
            a.ESL.l((b)localyn);
          }
        }
        AppMethodBeat.o(200355);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    public static final d LhR;
    
    static
    {
      AppMethodBeat.i(200358);
      LhR = new d();
      AppMethodBeat.o(200358);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(200357);
      paramDialogInterface = FinderDebugUIC.LhK;
      ad.i(FinderDebugUIC.access$getTAG$cp(), "onClickCancel");
      AppMethodBeat.o(200357);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(Context paramContext, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(200359);
      paramDialogInterface = FinderDebugUIC.LhK;
      ad.i(FinderDebugUIC.access$getTAG$cp(), "onClick1");
      paramDialogInterface = this.cjo.getSystemService("clipboard");
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new d.v("null cannot be cast to non-null type android.text.ClipboardManager");
        AppMethodBeat.o(200359);
        throw paramDialogInterface;
      }
      ((ClipboardManager)paramDialogInterface).setText((CharSequence)this.LhN);
      Toast.makeText(this.cjo, (CharSequence)"copy done", 0).show();
      AppMethodBeat.o(200359);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC
 * JD-Core Version:    0.7.0.1
 */