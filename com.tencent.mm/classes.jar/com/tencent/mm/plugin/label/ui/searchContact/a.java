package com.tencent.mm.plugin.label.ui.searchContact;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.bb;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItem;", "Lcom/tencent/mm/plugin/mvvmlist/BaseMvvmListItem;", "position", "", "(I)V", "HINT_TEXT_PAINT", "Landroid/text/TextPaint;", "getHINT_TEXT_PAINT", "()Landroid/text/TextPaint;", "HINT_TEXT_SIZE", "getHINT_TEXT_SIZE", "()I", "SPLIT_LABELS", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "TAG", "", "TITLE_TEXT_PAINT", "getTITLE_TEXT_PAINT", "TITLE_TEXT_SIZE", "getTITLE_TEXT_SIZE", "canReport", "", "getCanReport", "()Z", "setCanReport", "(Z)V", "chatroom", "contact", "Lcom/tencent/mm/storage/Contact;", "getContact", "()Lcom/tencent/mm/storage/Contact;", "setContact", "(Lcom/tencent/mm/storage/Contact;)V", "content", "", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "desc", "forceDark", "getForceDark", "setForceDark", "ftsQuery", "Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "getFtsQuery", "()Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "setFtsQuery", "(Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;)V", "isAASelectContactOpenIMUser", "isAASelectContactUser", "isBottom", "isFillingData", "setFillingData", "isHiddenDivider", "isShowTopPlaceBackGround", "isTopHit", "setTopHit", "kvPosition", "getKvPosition", "setKvPosition", "matchInfo", "Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;", "getMatchInfo", "()Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;", "setMatchInfo", "(Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;)V", "matchSubType", "getMatchSubType", "setMatchSubType", "matchType", "getMatchType", "setMatchType", "nickname", "getNickname", "setNickname", "openImDesc", "getOpenImDesc", "()Ljava/lang/String;", "setOpenImDesc", "(Ljava/lang/String;)V", "getPosition", "query", "scene", "getScene", "setScene", "skipOpenIMDesc", "getSkipOpenIMDesc", "setSkipOpenIMDesc", "username", "getUsername", "setUsername", "viewType", "compareTo", "other", "fillingDataItem", "", "context", "Landroid/content/Context;", "baseViewHolder", "Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItem$ContactViewHolder;", "fillingViewItem", "holder", "data", "alwaysCheck", "isCheck", "findTagString", "tags", "", "formatText", "match", "getChatroom", "getDesc", "getFTSQuery", "getItemType", "getQuery", "getUniqueId", "getViewType", "isAccuracyMatch", "isFillData", "isSameContent", "onItemClick", "v", "Landroid/view/View;", "setAASelectContactOpenIMUser", "aaSelectContactOpenIMUser", "setAASelectContactUser", "aaSelectContactUser", "setBottom", "setChatroom", "setDesc", "setFTSQuery", "setFillData", "setHiddenDivider", "hiddenDivider", "setQuery", "setShowTopPlaceBackGround", "showTopPlaceBackGround", "toEmoji", "Landroid/text/SpannableString;", "origin", "sizeInPx", "ContactViewHolder", "ViewType", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.mvvmlist.a<a>
{
  private boolean Bva;
  com.tencent.mm.plugin.fts.a.a.j FWt;
  private final int HwQ;
  private final TextPaint HwR;
  private final int HwS;
  private final TextPaint HwT;
  private boolean JXq;
  private boolean JXr;
  final String TAG;
  au contact;
  String hCy;
  CharSequence nnT;
  private final Pattern pJF;
  CharSequence pJG;
  final int position;
  String prR;
  String query;
  com.tencent.mm.plugin.fts.a.a.o rpp;
  String username;
  private int viewType;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(268910);
    this.position = paramInt;
    this.TAG = "MicroMsg.ContactDataItem";
    this.pJF = Pattern.compile(",");
    this.viewType = 2;
    this.HwQ = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), R.f.NormalTextSize);
    this.HwS = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), R.f.HintTextSize);
    this.HwR = new TextPaint();
    this.HwT = new TextPaint();
    this.HwR.setTextSize(this.HwQ);
    this.HwT.setTextSize(this.HwS);
    AppMethodBeat.o(268910);
  }
  
  private static final void a(a parama, a parama1, Context paramContext, a parama2)
  {
    AppMethodBeat.i(268926);
    s.u(parama, "$viewHolder");
    s.u(parama1, "$dataItem");
    s.u(paramContext, "$context");
    s.u(parama2, "this$0");
    try
    {
      localObject1 = parama.pJJ;
      s.checkNotNull(localObject1);
      localObject1 = ((TextView)localObject1).getParent();
      if (localObject1 == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(268926);
        throw parama;
      }
    }
    catch (Exception parama)
    {
      Log.e(parama2.TAG, "fillingViewItem Exception:%s %s", new Object[] { parama.getClass().getSimpleName(), parama.getMessage() });
      AppMethodBeat.o(268926);
      return;
    }
    int i = ((ViewGroup)localObject1).getMeasuredWidth();
    if (i == 0)
    {
      AppMethodBeat.o(268926);
      return;
    }
    Object localObject2 = s.X("@", parama1.prR);
    int j = com.tencent.mm.cd.a.br(paramContext, R.f.DescTextSize);
    TextView localTextView1 = new TextView(paramContext);
    localTextView1.getPaint().setTextSize(j);
    float f = localTextView1.getPaint().measureText(s.X(" ", localObject2));
    Object localObject1 = localTextView1.getPaint();
    TextView localTextView2 = parama.pJJ;
    s.checkNotNull(localTextView2);
    ((TextPaint)localObject1).setTextSize(localTextView2.getTextSize());
    if (f >= i * 0.6D)
    {
      localObject1 = TextUtils.ellipsize(parama1.pJG, localTextView1.getPaint(), (float)(i * 0.4D), TextUtils.TruncateAt.END);
      s.s(localObject1, "ellipsize(dataItem.nickn…TextUtils.TruncateAt.END)");
      f = localTextView1.getPaint().measureText(localObject1.toString());
      localTextView1.getPaint().setTextSize(j);
      parama1 = TextUtils.ellipsize((CharSequence)localObject2, localTextView1.getPaint(), i - f - 20.0F, TextUtils.TruncateAt.END);
      s.s(parama1, "ellipsize(openIMWording,…TextUtils.TruncateAt.END)");
    }
    for (;;)
    {
      localObject2 = p.b(paramContext, (CharSequence)(localObject1 + ' ' + parama1));
      paramContext = com.tencent.mm.cd.a.l(paramContext, R.e.openim_desc_text_color);
      ((SpannableString)localObject2).setSpan(new TextAppearanceSpan(null, 0, j, paramContext, paramContext), ((CharSequence)localObject1).length() + 1, ((CharSequence)localObject1).length() + 1 + parama1.length(), 33);
      ((SpannableString)localObject2).setSpan(new com.tencent.mm.cg.a(j), ((CharSequence)localObject1).length() + 1, ((CharSequence)localObject1).length() + 1 + parama1.length(), 33);
      com.tencent.mm.plugin.fts.ui.o.a((CharSequence)localObject2, parama.pJJ);
      AppMethodBeat.o(268926);
      return;
      localObject1 = TextUtils.ellipsize(parama1.pJG, localTextView1.getPaint(), i - f, TextUtils.TruncateAt.END);
      s.s(localObject1, "ellipsize(dataItem.nickn…TextUtils.TruncateAt.END)");
      parama1 = (CharSequence)localObject2;
    }
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(268934);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/searchContact/ContactDataItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    localObject = new Intent();
    parama = parama.contact;
    if (parama == null) {}
    for (parama = null;; parama = parama.field_username)
    {
      ((Intent)localObject).putExtra("Contact_User", parama);
      ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 62);
      c.b(paramView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/label/ui/searchContact/ContactDataItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(268934);
      return;
    }
  }
  
  static SpannableString o(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(268914);
    paramContext = p.d(paramContext, (CharSequence)paramString, paramInt);
    AppMethodBeat.o(268914);
    return paramContext;
  }
  
  public final void a(Context paramContext, a parama, a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(268959);
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(parama1, "data");
    Object localObject;
    if (parama1.username != null)
    {
      localObject = parama1.username;
      if (localObject == null)
      {
        localObject = null;
        s.checkNotNull(localObject);
        if (((Integer)localObject).intValue() <= 0) {
          break label483;
        }
        a.b.a(parama.lBC, parama1.username, 0.1F, false);
        label76:
        com.tencent.mm.plugin.fts.ui.o.a(parama1.pJG, parama.pJJ);
        com.tencent.mm.plugin.fts.ui.o.a(parama1.nnT, parama.plr);
        if (!this.Bva)
        {
          localObject = parama.pJL;
          s.checkNotNull(localObject);
          ((CheckBox)localObject).setBackgroundResource(R.g.mm_checkbox_btn);
        }
        localObject = parama.pJL;
        s.checkNotNull(localObject);
        ((CheckBox)localObject).setChecked(paramBoolean);
        localObject = parama.pJL;
        s.checkNotNull(localObject);
        ((CheckBox)localObject).setEnabled(true);
        localObject = parama.pJL;
        s.checkNotNull(localObject);
        ((CheckBox)localObject).setVisibility(0);
        localObject = parama.contentView;
        s.checkNotNull(localObject);
        ((View)localObject).setBackgroundResource(R.g.aa_seletct_contact_search_ui_item_selector);
        localObject = parama1.contact;
        if ((localObject == null) || (((az)localObject).field_deleteFlag != 1)) {
          break label505;
        }
      }
    }
    label483:
    label505:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = parama.plr;
        s.checkNotNull(localObject);
        ((TextView)localObject).setVisibility(0);
        localObject = parama.plr;
        s.checkNotNull(localObject);
        ((TextView)localObject).setText((CharSequence)paramContext.getString(R.l.select_contact_account_deleted));
      }
      if ((!this.JXq) && (parama.pJK != null))
      {
        localObject = parama.pJK;
        s.checkNotNull(localObject);
        ((TextView)localObject).setVisibility(8);
        if ((au.bwO(parama1.username)) && (!Util.isNullOrNil(parama1.prR)))
        {
          localObject = parama.pJJ;
          s.checkNotNull(localObject);
          ((TextView)localObject).post(new a..ExternalSyntheticLambda1(parama, parama1, paramContext, this));
        }
      }
      paramContext = parama.JXt;
      s.checkNotNull(paramContext);
      paramContext.setOnClickListener(new a..ExternalSyntheticLambda0(this));
      if (!parama1.JXr) {
        break label511;
      }
      paramContext = parama.lBC;
      s.checkNotNull(paramContext);
      paramContext.setAlpha(0.3F);
      paramContext = parama.pJJ;
      s.checkNotNull(paramContext);
      paramContext.setAlpha(0.3F);
      paramContext = parama.plr;
      s.checkNotNull(paramContext);
      paramContext.setAlpha(0.3F);
      paramContext = parama.pJL;
      s.checkNotNull(paramContext);
      paramContext.setAlpha(0.3F);
      if (parama.pJK == null) {
        break label588;
      }
      paramContext = parama.pJK;
      s.checkNotNull(paramContext);
      paramContext.setAlpha(0.3F);
      AppMethodBeat.o(268959);
      return;
      localObject = Integer.valueOf(((String)localObject).length());
      break;
      localObject = parama.lBC;
      s.checkNotNull(localObject);
      ((ImageView)localObject).setImageResource(R.g.default_avatar);
      break label76;
    }
    label511:
    paramContext = parama.lBC;
    s.checkNotNull(paramContext);
    paramContext.setAlpha(1.0F);
    paramContext = parama.pJJ;
    s.checkNotNull(paramContext);
    paramContext.setAlpha(1.0F);
    paramContext = parama.plr;
    s.checkNotNull(paramContext);
    paramContext.setAlpha(1.0F);
    paramContext = parama.pJL;
    s.checkNotNull(paramContext);
    paramContext.setAlpha(1.0F);
    if (parama.pJK != null)
    {
      paramContext = parama.pJK;
      s.checkNotNull(paramContext);
      paramContext.setAlpha(1.0F);
    }
    label588:
    AppMethodBeat.o(268959);
  }
  
  public final int bZB()
  {
    return 2;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(268977);
    Object localObject = super.clone();
    AppMethodBeat.o(268977);
    return localObject;
  }
  
  final String fM(List<String> paramList)
  {
    AppMethodBeat.i(268965);
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1 = this.FWt;
    s.checkNotNull(localObject1);
    localObject1 = ((com.tencent.mm.plugin.fts.a.a.j)localObject1).Htg;
    s.s(localObject1, "getFTSQuery()!!.phrases");
    int j = localObject1.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject3 = d.aEh(str);
          s.s(localObject3, "preProcessTag");
          localObject3 = (CharSequence)localObject3;
          s.s(localObject2, "keyword");
          if (n.i((CharSequence)localObject3, (CharSequence)localObject2))
          {
            localStringBuffer.append(str);
            localStringBuffer.append(",");
          }
        }
      }
      localStringBuffer.trimToSize();
      if (localStringBuffer.length() == 0)
      {
        AppMethodBeat.o(268965);
        return "";
      }
      paramList = localStringBuffer.substring(0, localStringBuffer.length() - 1);
      AppMethodBeat.o(268965);
      return paramList;
      i += 1;
    }
  }
  
  public final String fcs()
  {
    AppMethodBeat.i(268968);
    Object localObject = this.contact;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((az)localObject).field_username)
    {
      localObject = String.valueOf(localObject);
      AppMethodBeat.o(268968);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItem$ContactViewHolder;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "convertView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIV", "Landroid/widget/ImageView;", "getAvatarIV", "()Landroid/widget/ImageView;", "setAvatarIV", "(Landroid/widget/ImageView;)V", "commonLebalMoreImg", "getCommonLebalMoreImg", "setCommonLebalMoreImg", "common_lebal_more_img_container", "getCommon_lebal_more_img_container", "()Landroid/view/View;", "setCommon_lebal_more_img_container", "contentView", "getContentView", "setContentView", "descTV", "Landroid/widget/TextView;", "getDescTV", "()Landroid/widget/TextView;", "setDescTV", "(Landroid/widget/TextView;)V", "openImDesc", "getOpenImDesc", "setOpenImDesc", "selectCB", "Landroid/widget/CheckBox;", "getSelectCB", "()Landroid/widget/CheckBox;", "setSelectCB", "(Landroid/widget/CheckBox;)V", "titleTV", "getTitleTV", "setTitleTV", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends com.tencent.mm.view.recyclerview.j
  {
    private ImageView JXs;
    View JXt;
    View contentView;
    ImageView lBC;
    TextView pJJ;
    TextView pJK;
    CheckBox pJL;
    TextView plr;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(268849);
      Object localObject1 = paramView.getContext();
      Object localObject2 = paramView.findViewById(R.h.avatar_iv);
      if (localObject2 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(268849);
        throw paramView;
      }
      this.lBC = ((ImageView)localObject2);
      localObject2 = paramView.findViewById(R.h.title_tv);
      if (localObject2 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(268849);
        throw paramView;
      }
      this.pJJ = ((TextView)localObject2);
      localObject2 = paramView.findViewById(R.h.desc_tv);
      if (localObject2 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(268849);
        throw paramView;
      }
      this.plr = ((TextView)localObject2);
      this.contentView = paramView.findViewById(R.h.content_layout);
      localObject2 = paramView.findViewById(R.h.select_cb);
      if (localObject2 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.CheckBox");
        AppMethodBeat.o(268849);
        throw paramView;
      }
      this.pJL = ((CheckBox)localObject2);
      this.JXs = ((ImageView)paramView.findViewById(R.h.fBt));
      localObject2 = paramView.findViewById(R.h.openim_contact_desc);
      if (localObject2 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(268849);
        throw paramView;
      }
      this.pJK = ((TextView)localObject2);
      this.JXt = paramView.findViewById(R.h.fBu);
      localObject2 = this.JXs;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(bb.m((Context)localObject1, b.i.sns_label_more_btn, ((Context)localObject1).getResources().getColor(R.e.FG_4)));
      }
      localObject1 = this.JXs;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      paramView.setTag(this);
      AppMethodBeat.o(268849);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.searchContact.a
 * JD-Core Version:    0.7.0.1
 */