package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cg;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activityAvatarIcon", "", "getActivityAvatarIcon", "()Ljava/lang/String;", "setActivityAvatarIcon", "(Ljava/lang/String;)V", "activityCreateSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "activityCreatorNickName", "getActivityCreatorNickName", "setActivityCreatorNickName", "activityDesc", "getActivityDesc", "setActivityDesc", "activityDescSheet", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "getActivityEvent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "setActivityEvent", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;)V", "activityName", "getActivityName", "setActivityName", "activityPostSheet", "activityTopicId", "", "getActivityTopicId", "()J", "setActivityTopicId", "(J)V", "activityType", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "coverUrl", "getCoverUrl", "setCoverUrl", "descTextView", "Landroid/widget/TextView;", "iconImageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isEnablePost", "", "localCoverUrl", "getLocalCoverUrl", "setLocalCoverUrl", "mediaWidget", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "getMediaWidget", "()Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "setMediaWidget", "(Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;)V", "onClickListener", "Landroid/view/View$OnClickListener;", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "titleTextView", "confirmActivityType", "intent", "Landroid/content/Intent;", "srcActivityType", "deleteActivity", "", "doCheckScene", "jumpToActivityDesc", "jumpToPost", "jumpToSelectActivity", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "setEnable", "isEnable", "setIntentParam", "setText", "title", "desc", "showCreateActivitySheet", "showDescActivitySheet", "showPostActivitySheet", "update", "Companion", "plugin-finder_release"})
public final class FinderExtendActivityView
  extends FrameLayout
  implements com.tencent.mm.an.i
{
  private static final int AWt = 3001;
  private static final int AWu = 3002;
  private static final int AWv = 4001;
  private static final int AWw = 4002;
  private static final int AWx = 5001;
  private static final int AWy = 5002;
  public static final a AWz;
  private bfv ABi;
  private WeImageView AWo;
  private e AWp;
  private String AWq;
  private String AWr;
  private boolean AWs;
  private String activityName;
  private final View.OnClickListener bwV;
  private com.tencent.mm.plugin.finder.api.i contact;
  private String coverUrl;
  private long fuv;
  private TextView iXT;
  private TextView rrS;
  private String wYd;
  private String wYi;
  private int wYj;
  private com.tencent.mm.plugin.finder.widget.post.a yOR;
  
  static
  {
    AppMethodBeat.i(275018);
    AWz = new a((byte)0);
    AWt = 3001;
    AWu = 3002;
    AWv = 4001;
    AWw = 4002;
    AWx = 5001;
    AWy = 5002;
    AppMethodBeat.o(275018);
  }
  
  public FinderExtendActivityView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(275016);
    this.wYj = 100;
    this.ABi = new bfv();
    this.wYi = "";
    this.coverUrl = "";
    this.activityName = "";
    this.AWq = "";
    this.AWr = "";
    this.wYd = "";
    this.AWs = true;
    this.bwV = ((View.OnClickListener)new b(this));
    paramContext = ad.kS(getContext()).inflate(b.g.finder_post_activity_item_view, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(b.f.post_activity_item_title);
    p.j(paramAttributeSet, "view.findViewById(R.id.post_activity_item_title)");
    this.iXT = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(b.f.post_activity_item_desc);
    p.j(paramAttributeSet, "view.findViewById(R.id.post_activity_item_desc)");
    this.rrS = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(b.f.activity_flag_icon);
    p.j(paramContext, "view.findViewById(R.id.activity_flag_icon)");
    this.AWo = ((WeImageView)paramContext);
    setOnClickListener(this.bwV);
    AppMethodBeat.o(275016);
  }
  
  public FinderExtendActivityView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(275017);
    this.wYj = 100;
    this.ABi = new bfv();
    this.wYi = "";
    this.coverUrl = "";
    this.activityName = "";
    this.AWq = "";
    this.AWr = "";
    this.wYd = "";
    this.AWs = true;
    this.bwV = ((View.OnClickListener)new b(this));
    paramContext = ad.kS(getContext()).inflate(b.g.finder_post_activity_item_view, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(b.f.post_activity_item_title);
    p.j(paramAttributeSet, "view.findViewById(R.id.post_activity_item_title)");
    this.iXT = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(b.f.post_activity_item_desc);
    p.j(paramAttributeSet, "view.findViewById(R.id.post_activity_item_desc)");
    this.rrS = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(b.f.activity_flag_icon);
    p.j(paramContext, "view.findViewById(R.id.activity_flag_icon)");
    this.AWo = ((WeImageView)paramContext);
    setOnClickListener(this.bwV);
    AppMethodBeat.o(275017);
  }
  
  private final void T(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(275012);
    int i;
    if (paramString2 != null)
    {
      this.rrS.setVisibility(0);
      this.rrS.setText((CharSequence)paramString2);
      if (paramString2 != null) {}
    }
    else
    {
      paramString2 = this.rrS;
      if (!this.AWs) {
        break label150;
      }
      i = b.j.finder_activity_default_desc;
      paramString2.setText(i);
      paramString2 = x.aazN;
    }
    paramString2 = this.iXT;
    if ((paramInt == 101) || (paramInt == 102)) {
      if (paramString1 != null)
      {
        paramString1 = (CharSequence)paramString1;
        label86:
        paramString2.setText(paramString1);
        paramString2.setTextColor(paramString2.getResources().getColor(b.c.Orange));
      }
    }
    for (;;)
    {
      paramString1 = this.AWo;
      if ((paramInt != 101) && (paramInt != 102)) {
        break label198;
      }
      paramString1.setIconColor(paramString1.getResources().getColor(b.c.Orange));
      paramString1.setImageResource(b.i.finder_filled_activity);
      AppMethodBeat.o(275012);
      return;
      label150:
      i = b.j.finder_activity_disable_create;
      break;
      paramString1 = (CharSequence)"";
      break label86;
      paramString2.setText(paramString2.getResources().getText(b.j.finder_activity_title));
      paramString2.setTextColor(paramString2.getResources().getColor(b.c.normal_text_color));
    }
    label198:
    paramString1.setIconColor(paramString1.getResources().getColor(b.c.FG_0));
    paramString1.setImageResource(b.i.finder_outlined_activity);
    AppMethodBeat.o(275012);
  }
  
  private static boolean d(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(275010);
    if (((paramIntent.hasExtra("key_topic_id")) && ((paramInt == 101) || (paramInt == 102))) || (paramInt == 100))
    {
      AppMethodBeat.o(275010);
      return true;
    }
    AppMethodBeat.o(275010);
    return false;
  }
  
  private final void e(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(275011);
    if (paramIntent != null)
    {
      this.activityName = paramIntent.getStringExtra("key_activity_name");
      this.wYd = paramIntent.getStringExtra("key_activity_desc");
      this.AWq = paramIntent.getStringExtra("key_nick_name");
      this.AWr = paramIntent.getStringExtra("key_avatar_url");
      this.fuv = paramIntent.getLongExtra("key_topic_id", 0L);
      int i;
      if (paramInt != 100)
      {
        if (paramInt == 102)
        {
          i = 1;
          k localk = k.zWs;
          k.dU(d.Fw(this.fuv), i);
        }
      }
      else {
        switch (paramInt)
        {
        default: 
          this.wYi = "";
          this.coverUrl = "";
        }
      }
      for (;;)
      {
        T(this.activityName, this.wYd, paramInt);
        AppMethodBeat.o(275011);
        return;
        i = 2;
        break;
        this.wYi = paramIntent.getStringExtra("key_activity_local_cover_url");
        this.coverUrl = paramIntent.getStringExtra("key_cover_url");
        continue;
        this.coverUrl = paramIntent.getStringExtra("key_cover_url");
      }
    }
    AppMethodBeat.o(275011);
  }
  
  private final void eiA()
  {
    AppMethodBeat.i(275009);
    com.tencent.mm.plugin.finder.api.i locali = this.contact;
    if (locali != null)
    {
      if (this.wYj == 100)
      {
        com.tencent.mm.kernel.h.aGY().a(4050, (com.tencent.mm.an.i)this);
        com.tencent.mm.kernel.h.aGY().b((q)new cg(locali.getUsername(), null, null, null, 0L, 1, 30));
      }
      AppMethodBeat.o(275009);
      return;
    }
    AppMethodBeat.o(275009);
  }
  
  private final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(275015);
    this.AWs = paramBoolean;
    if (paramBoolean)
    {
      setAlpha(1.0F);
      setOnClickListener(this.bwV);
      localTextView = this.rrS;
      localContext = getContext();
      p.j(localContext, "context");
      localTextView.setTextColor(localContext.getResources().getColor(b.c.FG_2));
      this.rrS.setText(b.j.finder_activity_default_desc);
      AppMethodBeat.o(275015);
      return;
    }
    setAlpha(0.3F);
    setOnClickListener(null);
    TextView localTextView = this.rrS;
    Context localContext = getContext();
    p.j(localContext, "context");
    localTextView.setTextColor(localContext.getResources().getColor(b.c.BW_0_Alpha_0_8));
    this.rrS.setText(b.j.finder_activity_disable_create);
    AppMethodBeat.o(275015);
  }
  
  public final void c(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(275008);
    p.k(paramIntent, "intent");
    if (d(paramIntent, paramInt))
    {
      this.wYj = paramInt;
      e(paramIntent, paramInt);
    }
    eiA();
    AppMethodBeat.o(275008);
  }
  
  public final String getActivityAvatarIcon()
  {
    return this.AWr;
  }
  
  public final String getActivityCreatorNickName()
  {
    return this.AWq;
  }
  
  public final String getActivityDesc()
  {
    return this.wYd;
  }
  
  public final bfv getActivityEvent()
  {
    AppMethodBeat.i(275002);
    bfv localbfv = this.ABi;
    localbfv.xdR = this.fuv;
    String str = this.activityName;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbfv.eventName = ((String)localObject);
    str = this.AWq;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbfv.SQA = ((String)localObject);
    new StringBuilder("get activityEvent ").append(this.ABi.eventName).append(" eventTopicId:").append(this.ABi.xdR);
    com.tencent.d.f.h.ioq();
    localObject = this.ABi;
    AppMethodBeat.o(275002);
    return localObject;
  }
  
  public final String getActivityName()
  {
    return this.activityName;
  }
  
  public final long getActivityTopicId()
  {
    return this.fuv;
  }
  
  public final com.tencent.mm.plugin.finder.api.i getContact()
  {
    return this.contact;
  }
  
  public final String getCoverUrl()
  {
    return this.coverUrl;
  }
  
  public final String getLocalCoverUrl()
  {
    return this.wYi;
  }
  
  public final com.tencent.mm.plugin.finder.widget.post.a getMediaWidget()
  {
    return this.yOR;
  }
  
  public final View.OnClickListener getOnClickListener()
  {
    return this.bwV;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(275014);
    if ((paramq instanceof cg))
    {
      com.tencent.mm.kernel.h.aGY().b(4050, (com.tencent.mm.an.i)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        setEnable(true);
        AppMethodBeat.o(275014);
        return;
      }
      if (paramInt2 == -4064) {
        setEnable(false);
      }
    }
    AppMethodBeat.o(275014);
  }
  
  public final void setActivityAvatarIcon(String paramString)
  {
    this.AWr = paramString;
  }
  
  public final void setActivityCreatorNickName(String paramString)
  {
    this.AWq = paramString;
  }
  
  public final void setActivityDesc(String paramString)
  {
    this.wYd = paramString;
  }
  
  public final void setActivityEvent(bfv parambfv)
  {
    AppMethodBeat.i(275003);
    p.k(parambfv, "<set-?>");
    this.ABi = parambfv;
    AppMethodBeat.o(275003);
  }
  
  public final void setActivityName(String paramString)
  {
    this.activityName = paramString;
  }
  
  public final void setActivityTopicId(long paramLong)
  {
    this.fuv = paramLong;
  }
  
  public final void setContact(com.tencent.mm.plugin.finder.api.i parami)
  {
    this.contact = parami;
  }
  
  public final void setCoverUrl(String paramString)
  {
    this.coverUrl = paramString;
  }
  
  public final void setIntentParam(Intent paramIntent)
  {
    AppMethodBeat.i(275013);
    if (paramIntent != null)
    {
      Object localObject = this.contact;
      String str;
      if (localObject != null)
      {
        str = ((com.tencent.mm.plugin.finder.api.i)localObject).field_username;
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      paramIntent.putExtra("key_user_name", (String)localObject);
      if (Util.isNullOrNil(this.AWq))
      {
        localObject = this.contact;
        if (localObject != null)
        {
          str = ((com.tencent.mm.plugin.finder.api.i)localObject).getNickname();
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        paramIntent.putExtra("key_nick_name", (String)localObject);
        if (!Util.isNullOrNil(this.AWr)) {
          break label271;
        }
        localObject = this.contact;
        if (localObject != null)
        {
          str = ((com.tencent.mm.plugin.finder.api.i)localObject).Mm();
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        label117:
        paramIntent.putExtra("key_avatar_url", (String)localObject);
        paramIntent.putExtra("key_topic_id", this.fuv);
        str = this.activityName;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        paramIntent.putExtra("key_activity_name", (String)localObject);
        str = this.wYd;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        paramIntent.putExtra("key_activity_desc", (String)localObject);
        if (this.wYj != 101) {
          break label279;
        }
        str = this.wYi;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        paramIntent.putExtra("key_activity_local_cover_url", (String)localObject);
        str = this.coverUrl;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        p.j(paramIntent.putExtra("key_cover_url", (String)localObject), "putExtra(ConstantsUI.Fin…TY_COVER, coverUrl ?: \"\")");
      }
      for (;;)
      {
        paramIntent.putExtra("key_activity_type", this.wYj);
        AppMethodBeat.o(275013);
        return;
        localObject = this.AWq;
        break;
        label271:
        localObject = this.AWr;
        break label117;
        label279:
        if (this.wYj == 102)
        {
          str = this.coverUrl;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          paramIntent.putExtra("key_cover_url", (String)localObject);
          paramIntent.putExtra("key_is_from_post", true);
        }
      }
    }
    AppMethodBeat.o(275013);
  }
  
  public final void setLocalCoverUrl(String paramString)
  {
    this.wYi = paramString;
  }
  
  public final void setMediaWidget(com.tencent.mm.plugin.finder.widget.post.a parama)
  {
    this.yOR = parama;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView$Companion;", "", "()V", "ACTIVITY_TYPE_CREATE", "", "ACTIVITY_TYPE_NONE", "ACTIVITY_TYPE_SELECT", "MENU_ID_CREATE_DELETE", "MENU_ID_CREATE_MODIFY", "MENU_ID_DESC_DETAIL", "MENU_ID_DESC_EXIT", "MENU_ID_PARTICIPATE", "MENU_ID_POST_ACTIVITY", "REQUEST_CODE_PARTICIPATE_ACTIVITY", "REQUEST_CODE_PRE_POST_ACTIVITY", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderExtendActivityView paramFinderExtendActivityView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279621);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendActivityView$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      switch (FinderExtendActivityView.e(this.AWA))
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(279621);
        return;
        FinderExtendActivityView.f(this.AWA);
        continue;
        FinderExtendActivityView.b(this.AWA);
        continue;
        FinderExtendActivityView.a(this.AWA);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$showCreateActivitySheet$1$1"})
  static final class c
    implements q.f
  {
    c(FinderExtendActivityView paramFinderExtendActivityView) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(225607);
      p.j(paramo, "it");
      if (paramo.hJO())
      {
        paramo.a(FinderExtendActivityView.eiB(), this.AWA.getResources().getColor(b.c.FG_0), (CharSequence)this.AWA.getResources().getString(b.j.finder_activity_modify_text));
        paramo.a(FinderExtendActivityView.eiC(), this.AWA.getResources().getColor(b.c.FG_0), (CharSequence)this.AWA.getResources().getString(b.j.finder_activity_delete_text));
      }
      AppMethodBeat.o(225607);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$showCreateActivitySheet$1$2"})
  static final class d
    implements q.g
  {
    d(FinderExtendActivityView paramFinderExtendActivityView) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(257031);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == FinderExtendActivityView.eiB())
      {
        FinderExtendActivityView.a(this.AWA);
        AppMethodBeat.o(257031);
        return;
      }
      if (paramInt == FinderExtendActivityView.eiC()) {
        FinderExtendActivityView.c(this.AWA);
      }
      AppMethodBeat.o(257031);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$showCreateActivitySheet$1$3"})
  static final class e
    implements e.b
  {
    e(FinderExtendActivityView paramFinderExtendActivityView) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(270747);
      FinderExtendActivityView.d(this.AWA);
      AppMethodBeat.o(270747);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderExtendActivityView
 * JD-Core Version:    0.7.0.1
 */