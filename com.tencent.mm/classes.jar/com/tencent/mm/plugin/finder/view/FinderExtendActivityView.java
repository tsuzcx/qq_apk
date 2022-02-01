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
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activityCreateSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "activityDesc", "", "getActivityDesc", "()Ljava/lang/String;", "setActivityDesc", "(Ljava/lang/String;)V", "activityDescSheet", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "getActivityEvent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "setActivityEvent", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;)V", "activityName", "getActivityName", "setActivityName", "activityPostSheet", "activityTopicId", "", "getActivityTopicId", "()J", "setActivityTopicId", "(J)V", "activityType", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "coverUrl", "getCoverUrl", "setCoverUrl", "descTextView", "Landroid/widget/TextView;", "iconImageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "localCoverUrl", "getLocalCoverUrl", "setLocalCoverUrl", "mediaWidget", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "getMediaWidget", "()Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "setMediaWidget", "(Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;)V", "titleTextView", "confirmActivityType", "", "intent", "Landroid/content/Intent;", "srcActivityType", "deleteActivity", "", "jumpToActivityDesc", "jumpToPost", "jumpToSelectActivity", "refresh", "setIntentParam", "setText", "title", "desc", "showCreateActivitySheet", "showDescActivitySheet", "showPostActivitySheet", "update", "Companion", "plugin-finder_release"})
public final class FinderExtendActivityView
  extends FrameLayout
{
  private static final int wlA = 5001;
  private static final int wlB = 5002;
  public static final a wlC;
  private static final int wlw = 3001;
  private static final int wlx = 3002;
  private static final int wly = 4001;
  private static final int wlz = 4002;
  private String activityName;
  private g contact;
  private String coverUrl;
  private long dBT;
  private TextView gtI;
  private TextView oqv;
  private String trC;
  private int trD;
  private String trk;
  private com.tencent.mm.plugin.finder.widget.post.a vRf;
  private azs vTF;
  private WeImageView wlt;
  private e wlu;
  private e wlv;
  
  static
  {
    AppMethodBeat.i(254776);
    wlC = new a((byte)0);
    wlw = 3001;
    wlx = 3002;
    wly = 4001;
    wlz = 4002;
    wlA = 5001;
    wlB = 5002;
    AppMethodBeat.o(254776);
  }
  
  public FinderExtendActivityView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254774);
    this.trD = 100;
    this.vTF = new azs();
    this.trC = "";
    this.coverUrl = "";
    this.activityName = "";
    this.trk = "";
    paramContext = aa.jQ(getContext()).inflate(2131494562, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131306052);
    p.g(paramAttributeSet, "view.findViewById(R.id.post_activity_item_title)");
    this.gtI = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131306051);
    p.g(paramAttributeSet, "view.findViewById(R.id.post_activity_item_desc)");
    this.oqv = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131296457);
    p.g(paramContext, "view.findViewById(R.id.activity_flag_icon)");
    this.wlt = ((WeImageView)paramContext);
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(254760);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendActivityView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        switch (FinderExtendActivityView.g(this.wlD))
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(254760);
          return;
          FinderExtendActivityView.h(this.wlD);
          continue;
          FinderExtendActivityView.d(this.wlD);
          continue;
          FinderExtendActivityView.i(this.wlD);
        }
      }
    });
    AppMethodBeat.o(254774);
  }
  
  public FinderExtendActivityView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254775);
    this.trD = 100;
    this.vTF = new azs();
    this.trC = "";
    this.coverUrl = "";
    this.activityName = "";
    this.trk = "";
    paramContext = aa.jQ(getContext()).inflate(2131494562, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131306052);
    p.g(paramAttributeSet, "view.findViewById(R.id.post_activity_item_title)");
    this.gtI = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131306051);
    p.g(paramAttributeSet, "view.findViewById(R.id.post_activity_item_desc)");
    this.oqv = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131296457);
    p.g(paramContext, "view.findViewById(R.id.activity_flag_icon)");
    this.wlt = ((WeImageView)paramContext);
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(254760);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendActivityView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        switch (FinderExtendActivityView.g(this.wlD))
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(254760);
          return;
          FinderExtendActivityView.h(this.wlD);
          continue;
          FinderExtendActivityView.d(this.wlD);
          continue;
          FinderExtendActivityView.i(this.wlD);
        }
      }
    });
    AppMethodBeat.o(254775);
  }
  
  private final void P(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(254772);
    if (paramString2 != null)
    {
      this.oqv.setVisibility(0);
      this.oqv.setText((CharSequence)paramString2);
      if (paramString2 != null) {}
    }
    else
    {
      this.oqv.setVisibility(8);
      paramString2 = x.SXb;
    }
    paramString2 = this.gtI;
    if ((paramInt == 101) || (paramInt == 102)) {
      if (paramString1 != null)
      {
        paramString1 = (CharSequence)paramString1;
        paramString2.setText(paramString1);
        paramString2.setTextColor(paramString2.getResources().getColor(2131099792));
      }
    }
    for (;;)
    {
      paramString1 = this.wlt;
      if ((paramInt != 101) && (paramInt != 102)) {
        break label176;
      }
      paramString1.setIconColor(paramString1.getResources().getColor(2131099792));
      paramString1.setImageResource(2131690235);
      AppMethodBeat.o(254772);
      return;
      paramString1 = (CharSequence)"";
      break;
      paramString2.setText(paramString2.getResources().getText(2131759526));
      paramString2.setTextColor(paramString2.getResources().getColor(2131100904));
    }
    label176:
    paramString1.setIconColor(paramString1.getResources().getColor(2131099746));
    paramString1.setImageResource(2131690281);
    AppMethodBeat.o(254772);
  }
  
  private static boolean c(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(254770);
    if (((paramIntent.hasExtra("key_topic_id")) && ((paramInt == 101) || (paramInt == 102))) || (paramInt == 100))
    {
      AppMethodBeat.o(254770);
      return true;
    }
    AppMethodBeat.o(254770);
    return false;
  }
  
  private final void d(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(254771);
    if (paramIntent != null)
    {
      this.activityName = paramIntent.getStringExtra("key_activity_name");
      this.trk = paramIntent.getStringExtra("key_activity_desc");
      this.dBT = paramIntent.getLongExtra("key_topic_id", 0L);
      if (paramInt != 100)
      {
        i locali = i.vfo;
        i.dz(d.zs(this.dBT), paramInt);
      }
      switch (paramInt)
      {
      default: 
        this.trC = "";
        this.coverUrl = "";
      }
      for (;;)
      {
        P(this.activityName, this.trk, paramInt);
        AppMethodBeat.o(254771);
        return;
        this.trC = paramIntent.getStringExtra("key_activity_local_cover_url");
        this.coverUrl = paramIntent.getStringExtra("key_cover_url");
        continue;
        this.coverUrl = paramIntent.getStringExtra("key_cover_url");
      }
    }
    AppMethodBeat.o(254771);
  }
  
  public final void b(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(254769);
    p.h(paramIntent, "intent");
    if (c(paramIntent, paramInt))
    {
      this.trD = paramInt;
      d(paramIntent, paramInt);
    }
    AppMethodBeat.o(254769);
  }
  
  public final String getActivityDesc()
  {
    return this.trk;
  }
  
  public final azs getActivityEvent()
  {
    AppMethodBeat.i(254767);
    azs localazs = this.vTF;
    localazs.twd = this.dBT;
    String str = this.activityName;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localazs.eventName = ((String)localObject);
    new StringBuilder("get activityEvent ").append(this.vTF.eventName).append(" eventTopicId:").append(this.vTF.twd);
    h.hkS();
    localObject = this.vTF;
    AppMethodBeat.o(254767);
    return localObject;
  }
  
  public final String getActivityName()
  {
    return this.activityName;
  }
  
  public final long getActivityTopicId()
  {
    return this.dBT;
  }
  
  public final g getContact()
  {
    return this.contact;
  }
  
  public final String getCoverUrl()
  {
    return this.coverUrl;
  }
  
  public final String getLocalCoverUrl()
  {
    return this.trC;
  }
  
  public final com.tencent.mm.plugin.finder.widget.post.a getMediaWidget()
  {
    return this.vRf;
  }
  
  public final void setActivityDesc(String paramString)
  {
    this.trk = paramString;
  }
  
  public final void setActivityEvent(azs paramazs)
  {
    AppMethodBeat.i(254768);
    p.h(paramazs, "<set-?>");
    this.vTF = paramazs;
    AppMethodBeat.o(254768);
  }
  
  public final void setActivityName(String paramString)
  {
    this.activityName = paramString;
  }
  
  public final void setActivityTopicId(long paramLong)
  {
    this.dBT = paramLong;
  }
  
  public final void setContact(g paramg)
  {
    this.contact = paramg;
  }
  
  public final void setCoverUrl(String paramString)
  {
    this.coverUrl = paramString;
  }
  
  public final void setIntentParam(Intent paramIntent)
  {
    AppMethodBeat.i(254773);
    if (paramIntent != null)
    {
      Object localObject = this.contact;
      if (localObject != null)
      {
        str = ((g)localObject).field_username;
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      paramIntent.putExtra("key_user_name", (String)localObject);
      localObject = this.contact;
      if (localObject != null)
      {
        str = ((g)localObject).getNickname();
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      paramIntent.putExtra("key_nick_name", (String)localObject);
      localObject = this.contact;
      if (localObject != null)
      {
        str = ((g)localObject).cXH();
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      paramIntent.putExtra("key_avatar_url", (String)localObject);
      paramIntent.putExtra("key_topic_id", this.dBT);
      String str = this.activityName;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramIntent.putExtra("key_activity_name", (String)localObject);
      str = this.trk;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramIntent.putExtra("key_activity_desc", (String)localObject);
      if (this.trD == 101)
      {
        str = this.trC;
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
        p.g(paramIntent.putExtra("key_cover_url", (String)localObject), "putExtra(ConstantsUI.Fin…TY_COVER, coverUrl ?: \"\")");
      }
      for (;;)
      {
        paramIntent.putExtra("key_activity_type", this.trD);
        AppMethodBeat.o(254773);
        return;
        if (this.trD == 102)
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
    AppMethodBeat.o(254773);
  }
  
  public final void setLocalCoverUrl(String paramString)
  {
    this.trC = paramString;
  }
  
  public final void setMediaWidget(com.tencent.mm.plugin.finder.widget.post.a parama)
  {
    this.vRf = parama;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView$Companion;", "", "()V", "ACTIVITY_TYPE_CREATE", "", "ACTIVITY_TYPE_NONE", "ACTIVITY_TYPE_SELECT", "MENU_ID_CREATE_DELETE", "MENU_ID_CREATE_MODIFY", "MENU_ID_DESC_DETAIL", "MENU_ID_DESC_EXIT", "MENU_ID_PARTICIPATE", "MENU_ID_POST_ACTIVITY", "REQUEST_CODE_PARTICIPATE_ACTIVITY", "REQUEST_CODE_PRE_POST_ACTIVITY", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$showCreateActivitySheet$1$1"})
  static final class b
    implements o.f
  {
    b(FinderExtendActivityView paramFinderExtendActivityView) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(254761);
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.a(FinderExtendActivityView.dGC(), this.wlD.getResources().getColor(2131099746), (CharSequence)this.wlD.getResources().getString(2131759504));
        paramm.a(FinderExtendActivityView.dGD(), this.wlD.getResources().getColor(2131099746), (CharSequence)this.wlD.getResources().getString(2131759495));
      }
      AppMethodBeat.o(254761);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$showCreateActivitySheet$1$2"})
  static final class c
    implements o.g
  {
    c(FinderExtendActivityView paramFinderExtendActivityView) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(254762);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == FinderExtendActivityView.dGC())
      {
        FinderExtendActivityView.a(this.wlD);
        AppMethodBeat.o(254762);
        return;
      }
      if (paramInt == FinderExtendActivityView.dGD()) {
        FinderExtendActivityView.e(this.wlD);
      }
      AppMethodBeat.o(254762);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$showCreateActivitySheet$1$3"})
  static final class d
    implements e.b
  {
    d(FinderExtendActivityView paramFinderExtendActivityView) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(254763);
      FinderExtendActivityView.f(this.wlD);
      AppMethodBeat.o(254763);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$showPostActivitySheet$1$1"})
  static final class e
    implements o.f
  {
    e(FinderExtendActivityView paramFinderExtendActivityView) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(254764);
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.a(FinderExtendActivityView.dGA(), this.wlD.getResources().getColor(2131099746), (CharSequence)this.wlD.getResources().getString(2131759525));
        paramm.a(FinderExtendActivityView.dGB(), this.wlD.getResources().getColor(2131099746), (CharSequence)this.wlD.getResources().getString(2131759524));
      }
      AppMethodBeat.o(254764);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$showPostActivitySheet$1$2"})
  static final class f
    implements o.g
  {
    f(FinderExtendActivityView paramFinderExtendActivityView) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(254765);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == FinderExtendActivityView.dGA())
      {
        FinderExtendActivityView.a(this.wlD);
        AppMethodBeat.o(254765);
        return;
      }
      if (paramInt == FinderExtendActivityView.dGB()) {
        FinderExtendActivityView.b(this.wlD);
      }
      AppMethodBeat.o(254765);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/view/FinderExtendActivityView$showPostActivitySheet$1$3"})
  static final class g
    implements e.b
  {
    g(FinderExtendActivityView paramFinderExtendActivityView) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(254766);
      FinderExtendActivityView.c(this.wlD);
      AppMethodBeat.o(254766);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderExtendActivityView
 * JD-Core Version:    0.7.0.1
 */