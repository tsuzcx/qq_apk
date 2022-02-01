package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.k.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.v;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDebugUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "MENU_CHECK_RELEATED_ID", "", "getMENU_CHECK_RELEATED_ID", "()I", "MENU_CHECK_VIDEO", "getMENU_CHECK_VIDEO", "MENU_COPY_ID", "getMENU_COPY_ID", "MENU_FORWARD_VIDEO", "getMENU_FORWARD_VIDEO", "MENU_INFO_ID", "getMENU_INFO_ID", "createDialog", "", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "createDialogInfo", "txt", "", "Companion", "plugin-finder_release"})
public final class FinderDebugUIC
  extends UIComponent
{
  public static final String TAG = "MicroMsg.FinderDebugUIC";
  public static final FinderDebugUIC.a sdn;
  final int sdi;
  final int sdj;
  final int sdk;
  final int sdl;
  final int sdm;
  
  static
  {
    AppMethodBeat.i(204486);
    sdn = new FinderDebugUIC.a((byte)0);
    TAG = "MicroMsg.FinderDebugUIC";
    AppMethodBeat.o(204486);
  }
  
  public FinderDebugUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(204485);
    this.sdi = 1;
    this.sdj = 2;
    this.sdk = 3;
    this.sdl = 4;
    this.sdm = 5;
    AppMethodBeat.o(204485);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class b
    implements n.c
  {
    public b(FinderDebugUIC paramFinderDebugUIC, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(204479);
      paraml.a(this.sdo.sdi, (CharSequence)"feed信息", 2131691484);
      paraml.a(this.sdo.sdk, (CharSequence)"强化流检查", 2131689825);
      if (this.sdp)
      {
        paraml.a(this.sdo.sdl, (CharSequence)"VIDEO信息", 2131689797);
        paraml.a(this.sdo.sdm, (CharSequence)"转发视频文件", 2131689831);
      }
      paraml.a(this.sdo.sdj, (CharSequence)"拷贝feed全量信息", 2131689829);
      AppMethodBeat.o(204479);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  public static final class c
    implements n.d
  {
    public c(FinderDebugUIC paramFinderDebugUIC, Context paramContext, String paramString1, BaseFinderFeed paramBaseFinderFeed, long paramLong, String paramString2, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      Object localObject1 = null;
      AppMethodBeat.i(204481);
      d.g.b.k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == this.sdo.sdi)
      {
        FinderDebugUIC.aq(this.cgl, this.sdq);
        AppMethodBeat.o(204481);
        return;
      }
      Object localObject2;
      boolean bool;
      if (paramInt == this.sdo.sdk)
      {
        paramMenuItem = this.cgl;
        localObject1 = new StringBuilder("后台配置:");
        localObject2 = g.rEP;
        localObject1 = ((StringBuilder)localObject1).append(g.uV(this.rav.feedObject.getId())).append(" \n是否触发拉取过:");
        localObject2 = g.rEP;
        if (!g.uW(this.qZv)) {}
        for (bool = true;; bool = false)
        {
          FinderDebugUIC.aq(paramMenuItem, bool);
          AppMethodBeat.o(204481);
          return;
        }
      }
      if (paramInt == this.sdo.sdl)
      {
        paramMenuItem = (bqs)j.iP((List)this.rav.feedObject.getMediaList());
        if (paramMenuItem != null)
        {
          localObject1 = c.rFo;
          paramMenuItem = c.b(paramMenuItem);
          localObject1 = SightVideoJNI.getSimpleMp4InfoVFS(paramMenuItem.getPath());
          bool = SightVideoJNI.isH265VideoVFS(paramMenuItem.getPath());
          localObject2 = new StringBuilder("path:").append(paramMenuItem.getPath()).append(" \nsize:").append(bs.qz(i.aSp(paramMenuItem.getPath()))).append('\n').append("mediaId:").append(paramMenuItem.rtl.mediaId).append('\n').append("url=");
          paramMenuItem = (bqs)j.iP((List)this.rav.feedObject.getMediaList());
          if (paramMenuItem != null) {}
          for (paramMenuItem = paramMenuItem.url;; paramMenuItem = null)
          {
            paramMenuItem = paramMenuItem + " \n" + (String)localObject1 + " \nisH265:" + bool;
            FinderDebugUIC.aq(this.cgl, paramMenuItem);
            AppMethodBeat.o(204481);
            return;
          }
        }
        AppMethodBeat.o(204481);
        return;
      }
      if (paramInt == this.sdo.sdm)
      {
        paramMenuItem = (bqs)j.iP((List)this.rav.feedObject.getMediaList());
        if (paramMenuItem != null)
        {
          localObject2 = c.rFo;
          localObject2 = c.b(paramMenuItem);
          Object localObject3 = new StringBuilder("path:").append(((com.tencent.mm.plugin.finder.loader.l)localObject2).getPath()).append(" \nsize:").append(bs.qz(i.aSp(((com.tencent.mm.plugin.finder.loader.l)localObject2).getPath()))).append('\n').append("mediaId:").append(((com.tencent.mm.plugin.finder.loader.l)localObject2).rtl.mediaId).append('\n').append("url=");
          Object localObject4 = (bqs)j.iP((List)this.rav.feedObject.getMediaList());
          paramMenuItem = (MenuItem)localObject1;
          if (localObject4 != null) {
            paramMenuItem = ((bqs)localObject4).url;
          }
          paramMenuItem = paramMenuItem;
          localObject1 = new Intent();
          localObject4 = new WXFileObject();
          ((WXFileObject)localObject4).setFilePath(((com.tencent.mm.plugin.finder.loader.l)localObject2).getPath());
          localObject3 = new WXMediaMessage();
          ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject4);
          localObject2 = new com.tencent.mm.vfs.e(((com.tencent.mm.plugin.finder.loader.l)localObject2).getPath());
          ((WXMediaMessage)localObject3).title = ((com.tencent.mm.vfs.e)localObject2).getName();
          ((WXMediaMessage)localObject3).description = bs.qz(((com.tencent.mm.vfs.e)localObject2).length());
          ((Intent)localObject1).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject1).putExtra("select_is_ret", true);
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
          localObject2 = this.cgl;
          if (localObject2 == null)
          {
            paramMenuItem = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(204481);
            throw paramMenuItem;
          }
          localObject2 = (MMActivity)localObject2;
          localObject4 = com.tencent.mm.plugin.finder.utils.k.rPa;
          d.a((MMActivity)localObject2, ".ui.transmit.SelectConversationUI", (Intent)localObject1, k.a.cDb(), (MMActivity.a)new FinderDebugUIC.c.a((WXMediaMessage)localObject3, paramMenuItem));
          AppMethodBeat.o(204481);
          return;
        }
        AppMethodBeat.o(204481);
        return;
      }
      if (paramInt == this.sdo.sdj)
      {
        paramMenuItem = ai.getContext().getSystemService("clipboard");
        if (paramMenuItem == null)
        {
          paramMenuItem = new v("null cannot be cast to non-null type android.text.ClipboardManager");
          AppMethodBeat.o(204481);
          throw paramMenuItem;
        }
        ((ClipboardManager)paramMenuItem).setText((CharSequence)this.sdr);
        Toast.makeText(this.ojH.getContext(), (CharSequence)("debug info " + this.sdr), 1).show();
      }
      AppMethodBeat.o(204481);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    public static final d sdu;
    
    static
    {
      AppMethodBeat.i(204483);
      sdu = new d();
      AppMethodBeat.o(204483);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(204482);
      paramDialogInterface = FinderDebugUIC.sdn;
      ac.i(FinderDebugUIC.access$getTAG$cp(), "onClickCancel");
      AppMethodBeat.o(204482);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(Context paramContext, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(204484);
      paramDialogInterface = FinderDebugUIC.sdn;
      ac.i(FinderDebugUIC.access$getTAG$cp(), "onClick1");
      paramDialogInterface = this.cgl.getSystemService("clipboard");
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new v("null cannot be cast to non-null type android.text.ClipboardManager");
        AppMethodBeat.o(204484);
        throw paramDialogInterface;
      }
      ((ClipboardManager)paramDialogInterface).setText((CharSequence)this.sdq);
      Toast.makeText(this.cgl, (CharSequence)"copy done", 0).show();
      AppMethodBeat.o(204484);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC
 * JD-Core Version:    0.7.0.1
 */