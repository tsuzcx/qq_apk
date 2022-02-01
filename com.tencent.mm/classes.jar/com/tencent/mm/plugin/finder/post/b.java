package com.tencent.mm.plugin.finder.post;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.publish.l.b;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.utils.as;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.plugin.finder.view.FinderPostFooter;
import com.tencent.mm.plugin.finder.view.FinderPostFooter.b;
import com.tencent.mm.plugin.finder.view.manager.e;
import com.tencent.mm.plugin.finder.widget.post.c;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/post/PostEditUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "getDescTv", "()Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "setDescTv", "(Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;)V", "footer", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "getFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "setFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;)V", "footerContainer", "Landroid/view/View;", "getFooterContainer", "()Landroid/view/View;", "setFooterContainer", "(Landroid/view/View;)V", "footerTopicLayout", "Landroid/widget/LinearLayout;", "oldFooterHeight", "", "getOldFooterHeight", "()I", "setOldFooterHeight", "(I)V", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "getPostDataManager", "()Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "postDataManager$delegate", "Lkotlin/Lazy;", "scrollView", "Landroid/widget/ScrollView;", "getScrollView", "()Landroid/widget/ScrollView;", "scrollView$delegate", "selectionStart", "getSelectionStart", "setSelectionStart", "styleManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "getStyleManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "setStyleManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;)V", "textCountTv", "Landroid/widget/TextView;", "textOk", "", "getTextOk", "()Z", "setTextOk", "(Z)V", "addTopicStr", "", "topicStr", "inputTopicStr", "checkNextEnable", "initDescText", "initView", "isDescInitialized", "onDestroy", "onSelectContact", "resultCode", "data", "Landroid/content/Intent;", "onTopicClick", "postTopicUic", "Lcom/tencent/mm/plugin/finder/post/PostTopicUIC;", "saveDescData", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
  implements FinderPostFooter.b
{
  private TextView DXu;
  public FinderPostEditText ESV;
  public FinderPostFooter ESW;
  public View ESX;
  boolean ESY;
  int ESZ;
  public com.tencent.mm.plugin.finder.view.manager.d ETa;
  private final j ETb;
  private final j ETc;
  private final String TAG;
  int selectionStart;
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(349414);
    this.TAG = "Finder.FinderPostUI";
    this.ESY = true;
    this.selectionStart = -1;
    this.ETb = kotlin.k.cm((a)new d(paramAppCompatActivity));
    this.ETc = kotlin.k.cm((a)new e(paramAppCompatActivity));
    AppMethodBeat.o(349414);
  }
  
  private static final boolean a(b paramb, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(349455);
    s.u(paramb, "this$0");
    if (s.p(paramView, paramb.eGZ())) {
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(349455);
      return false;
      paramb.ewP().requestDisallowInterceptTouchEvent(true);
      continue;
      paramb.ewP().requestDisallowInterceptTouchEvent(false);
    }
  }
  
  private final h eHd()
  {
    AppMethodBeat.i(349433);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.d(getActivity()).q(h.class);
    s.s(localObject, "UICProvider.of(activity)…PostTopicUIC::class.java)");
    localObject = (h)localObject;
    AppMethodBeat.o(349433);
    return localObject;
  }
  
  private final ScrollView ewP()
  {
    AppMethodBeat.i(349421);
    ScrollView localScrollView = (ScrollView)this.ETc.getValue();
    AppMethodBeat.o(349421);
    return localScrollView;
  }
  
  private final void hX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(349445);
    int j = eGZ().getSelectionStart();
    String str1 = eGZ().getText().toString();
    int i;
    if (((CharSequence)paramString2).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label134;
      }
      i = j - paramString2.length();
      label52:
      if (j != 0) {
        break label139;
      }
      paramString2 = s.X(paramString1, str1);
      label64:
      if (i <= 0) {
        break label533;
      }
      i += paramString1.length();
    }
    for (;;)
    {
      this.selectionStart = i;
      eGZ().setText((CharSequence)p.b((Context)getContext(), (CharSequence)paramString2));
      eGZ().requestFocus();
      eGZ().setSelection(this.selectionStart);
      AppMethodBeat.o(349445);
      return;
      i = 0;
      break;
      label134:
      i = 0;
      break label52;
      label139:
      if (j == str1.length())
      {
        if (i > 0)
        {
          paramString2 = new StringBuilder();
          if (str1 == null)
          {
            paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(349445);
            throw paramString1;
          }
          str2 = str1.substring(0, i);
          s.s(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          paramString2 = paramString2.append(str2).append(paramString1);
          k = str1.length();
          if (str1 == null)
          {
            paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(349445);
            throw paramString1;
          }
          str1 = str1.substring(i + 1, k);
          s.s(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          paramString2 = str1;
          break label64;
        }
        paramString2 = s.X(str1, paramString1);
        break label64;
      }
      if (i > 0)
      {
        paramString2 = new StringBuilder();
        if (str1 == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(349445);
          throw paramString1;
        }
        str2 = str1.substring(0, i);
        s.s(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramString2 = paramString2.append(str2).append(paramString1);
        k = str1.length();
        if (str1 == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(349445);
          throw paramString1;
        }
        str1 = str1.substring(i + 1, k);
        s.s(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramString2 = str1;
        break label64;
      }
      paramString2 = new StringBuilder();
      if (str1 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(349445);
        throw paramString1;
      }
      String str2 = str1.substring(0, j);
      s.s(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString2 = paramString2.append(str2).append(paramString1);
      int k = str1.length();
      if (str1 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(349445);
        throw paramString1;
      }
      str1 = str1.substring(j, k);
      s.s(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString2 = str1;
      break label64;
      label533:
      i = paramString1.length() + j;
    }
  }
  
  public final FinderPostEditText eGZ()
  {
    AppMethodBeat.i(349489);
    FinderPostEditText localFinderPostEditText = this.ESV;
    if (localFinderPostEditText != null)
    {
      AppMethodBeat.o(349489);
      return localFinderPostEditText;
    }
    s.bIx("descTv");
    AppMethodBeat.o(349489);
    return null;
  }
  
  public final FinderPostFooter eHa()
  {
    AppMethodBeat.i(349495);
    FinderPostFooter localFinderPostFooter = this.ESW;
    if (localFinderPostFooter != null)
    {
      AppMethodBeat.o(349495);
      return localFinderPostFooter;
    }
    s.bIx("footer");
    AppMethodBeat.o(349495);
    return null;
  }
  
  public final View eHb()
  {
    AppMethodBeat.i(349503);
    View localView = this.ESX;
    if (localView != null)
    {
      AppMethodBeat.o(349503);
      return localView;
    }
    s.bIx("footerContainer");
    AppMethodBeat.o(349503);
    return null;
  }
  
  public final com.tencent.mm.plugin.finder.view.manager.d eHc()
  {
    AppMethodBeat.i(349510);
    com.tencent.mm.plugin.finder.view.manager.d locald = this.ETa;
    if (locald != null)
    {
      AppMethodBeat.o(349510);
      return locald;
    }
    s.bIx("styleManager");
    AppMethodBeat.o(349510);
    return null;
  }
  
  public final void eHe()
  {
    AppMethodBeat.i(349551);
    as localas = as.GiG;
    hX(s.X("", Character.valueOf(as.ffM())), "");
    if (eHb().getVisibility() == 8) {
      ((MMActivity)getActivity()).showVKB();
    }
    AppMethodBeat.o(349551);
  }
  
  public final void eHf()
  {
    AppMethodBeat.i(349561);
    Object localObject1 = eGZ().getText().toString();
    getIntent().putExtra("saveDesc", (String)localObject1);
    localObject1 = getIntent();
    Object localObject2 = eHc().fmb();
    ArrayList localArrayList = new ArrayList();
    localObject2 = ((Map)((com.tencent.mm.plugin.finder.view.manager.b)localObject2).GHC).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Map.Entry)localObject3).getKey();
      localObject3 = (djg)((Map.Entry)localObject3).getValue();
      com.tencent.mm.plugin.finder.utils.h localh = com.tencent.mm.plugin.finder.utils.h.Gga;
      localArrayList.add(com.tencent.mm.plugin.finder.utils.h.c((djg)localObject3));
    }
    ((Intent)localObject1).putExtra("saveDescAt", (Serializable)localArrayList);
    AppMethodBeat.o(349561);
  }
  
  public final void f(int paramInt, Intent paramIntent)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(349542);
    int m;
    Object localObject1;
    if (paramIntent != null)
    {
      m = paramIntent.getIntExtra("key_scene", 1);
      if (paramInt == -1)
      {
        paramInt = paramIntent.getIntExtra("key_source", 2);
        localObject1 = paramIntent.getByteArrayExtra("key_select_contact");
        if (localObject1 == null) {
          break label857;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = new djg();
        paramIntent.parseFrom((byte[])localObject1);
        if (paramIntent == null) {
          break label847;
        }
        if (!Util.isNullOrNil(paramIntent.nickname))
        {
          localObject3 = eHc().fmb();
          localObject2 = paramIntent.nickname;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((com.tencent.mm.plugin.finder.view.manager.b)localObject3).bI(paramInt, (String)localObject1);
          localObject3 = eHc().fmb().GHC;
          localObject2 = paramIntent.nickname;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((HashMap)localObject3).put(localObject1, paramIntent);
          int k = eGZ().getSelectionEnd();
          localObject2 = eGZ().getText().toString();
          paramInt = k;
          localObject1 = localObject2;
          if (m == 2)
          {
            m = eGZ().getSelectionEnd();
            paramInt = k;
            localObject1 = localObject2;
            if (m > 0)
            {
              k = m - 1;
              paramInt = i;
              i = k;
              if ((i >= 0) && (paramInt != 0)) {
                if (eGZ().getText().toString().charAt(i) == '@')
                {
                  i -= 1;
                  continue;
                }
              }
            }
          }
        }
      }
      catch (Exception paramIntent)
      {
        Log.e(this.TAG, "onActivityResult LocalFinderAtContact parseFrom:%s", new Object[] { paramIntent.getMessage() });
        paramIntent = null;
        continue;
        paramInt = 0;
        continue;
        i += 1;
        paramInt = i;
        if (i > ((String)localObject2).length()) {
          paramInt = ((String)localObject2).length();
        }
        if (localObject2 == null)
        {
          paramIntent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(349542);
          throw paramIntent;
        }
        localObject1 = ((String)localObject2).substring(0, paramInt);
        s.s(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        i = ((String)localObject2).length();
        if (localObject2 == null)
        {
          paramIntent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(349542);
          throw paramIntent;
        }
        Object localObject2 = ((String)localObject2).substring(m, i);
        s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = s.X((String)localObject1, localObject2);
        i = paramInt;
        if (paramInt > ((String)localObject1).length()) {
          i = ((String)localObject1).length();
        }
        localObject2 = new StringBuilder();
        if (localObject1 == null)
        {
          paramIntent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(349542);
          throw paramIntent;
        }
        Object localObject3 = ((String)localObject1).substring(0, i);
        s.s(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append('@').append(paramIntent.nickname).append(' ');
        paramInt = ((String)localObject1).length();
        if (localObject1 == null)
        {
          paramIntent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(349542);
          throw paramIntent;
        }
        localObject1 = ((String)localObject1).substring(i, paramInt);
        s.s(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = (String)localObject1;
        paramIntent = paramIntent.nickname;
        if (paramIntent != null) {}
      }
      for (paramInt = j;; paramInt = paramIntent.length())
      {
        eGZ().setText((CharSequence)p.b((Context)getContext(), (CharSequence)localObject1));
        eGZ().setSelection(i + paramInt + 2);
        AppMethodBeat.o(349542);
        return;
      }
      com.tencent.mm.plugin.finder.view.manager.b.a(eHc().fmb());
      if (m == 2)
      {
        localObject1 = eGZ().getText().toString();
        j = eGZ().getSelectionEnd();
        if (j > 0)
        {
          paramInt = j - 1;
          i = 1;
          while ((paramInt >= 0) && (i != 0)) {
            if (eGZ().getText().toString().charAt(paramInt) == '@') {
              paramInt -= 1;
            } else {
              i = 0;
            }
          }
          paramInt += 1;
          if (paramInt <= ((String)localObject1).length()) {
            break label854;
          }
          paramInt = ((String)localObject1).length();
        }
      }
      label847:
      label854:
      for (;;)
      {
        if (localObject1 == null)
        {
          paramIntent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(349542);
          throw paramIntent;
        }
        paramIntent = ((String)localObject1).substring(0, paramInt);
        s.s(paramIntent, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        i = ((String)localObject1).length();
        if (localObject1 == null)
        {
          paramIntent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(349542);
          throw paramIntent;
        }
        localObject1 = ((String)localObject1).substring(j, i);
        s.s(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramIntent = s.X(paramIntent, localObject1);
        eGZ().setText((CharSequence)paramIntent);
        eGZ().setSelection(paramInt);
        AppMethodBeat.o(349542);
        return;
      }
      label857:
      paramIntent = null;
    }
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(349526);
    Object localObject1 = getActivity().findViewById(l.e.post_desc_edt);
    s.s(localObject1, "activity.findViewById(R.id.post_desc_edt)");
    localObject1 = (FinderPostEditText)localObject1;
    s.u(localObject1, "<set-?>");
    this.ESV = ((FinderPostEditText)localObject1);
    localObject1 = new com.tencent.mm.plugin.finder.view.manager.d(eGZ(), (MMActivity)getActivity());
    s.u(localObject1, "<set-?>");
    this.ETa = ((com.tencent.mm.plugin.finder.view.manager.d)localObject1);
    localObject1 = getActivity().findViewById(l.e.footer_container);
    s.s(localObject1, "activity.findViewById(R.id.footer_container)");
    s.u(localObject1, "<set-?>");
    this.ESX = ((View)localObject1);
    eHb().setVisibility(8);
    localObject1 = getActivity().findViewById(l.e.finder_comment_footer);
    s.s(localObject1, "activity.findViewById(R.id.finder_comment_footer)");
    localObject1 = (FinderPostFooter)localObject1;
    s.u(localObject1, "<set-?>");
    this.ESW = ((FinderPostFooter)localObject1);
    localObject1 = getActivity().findViewById(l.e.post_at_hint_container);
    Object localObject3 = getActivity().findViewById(l.e.post_topic_hint_container);
    FinderPostFooter localFinderPostFooter = eHa();
    MMActivity localMMActivity = (MMActivity)getActivity();
    View localView = eHb();
    MMEditText localMMEditText = (MMEditText)eGZ();
    FinderPostFooter.b localb = (FinderPostFooter.b)this;
    s.s(localObject1, "atBtn");
    s.s(localObject3, "topicBtn");
    localFinderPostFooter.a(localMMActivity, localView, localMMEditText, localb, (View)localObject1, (View)localObject3);
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (!com.tencent.mm.plugin.finder.storage.d.eRs()) {
      eHa().uV(false);
    }
    localObject1 = eHa();
    localObject3 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((FinderPostFooter)localObject1).uW(com.tencent.mm.plugin.finder.storage.d.eRt());
    localObject1 = getActivity().findViewById(l.e.textcount_hint);
    s.s(localObject1, "activity.findViewById(R.id.textcount_hint)");
    this.DXu = ((TextView)localObject1);
    localObject1 = this.DXu;
    if (localObject1 == null)
    {
      s.bIx("textCountTv");
      localObject1 = null;
      ((TextView)localObject1).setText((CharSequence)"");
      localObject1 = this.DXu;
      if (localObject1 != null) {
        break label466;
      }
      s.bIx("textCountTv");
      localObject1 = localObject2;
    }
    label466:
    for (;;)
    {
      ((TextView)localObject1).setVisibility(8);
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      localObject1 = (TextWatcher)new b(((Number)com.tencent.mm.plugin.finder.storage.d.eSm().bmg()).intValue(), this);
      eGZ().addTextChangedListener((TextWatcher)localObject1);
      if (((c)this.ETb.getValue()).isLongVideo) {
        eGZ().setFilters((InputFilter[])new b.a[] { new b.a() });
      }
      eGZ().setOnTouchListener(new b..ExternalSyntheticLambda0(this));
      eHd().EUd = ((m)new c(this));
      AppMethodBeat.o(349526);
      return;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(349547);
    super.onDestroy();
    eHc();
    AppMethodBeat.o(349547);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/post/PostEditUIC$initDescText$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements TextWatcher
  {
    b(int paramInt, b paramb) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      TextView localTextView = null;
      Object localObject2 = null;
      AppMethodBeat.i(349567);
      Object localObject1;
      int j;
      label105:
      Object localObject3;
      Object localObject4;
      if (paramEditable != null)
      {
        localObject1 = jdField_this;
        if (((b)localObject1).eGZ().getSelectionStart() <= 0) {
          break label604;
        }
        i = ((b)localObject1).eGZ().getSelectionStart();
        localObject1 = b.b((b)localObject1);
        if ((((h)localObject1).EUb) && (paramEditable != null))
        {
          int k = i - 1;
          j = k;
          if (k < 0) {
            j = i - 1;
          }
          if ((j < 0) || (j >= paramEditable.length())) {
            break label618;
          }
          if (((CharSequence)paramEditable).length() <= 0) {
            break label613;
          }
          i = 1;
          if (i == 0) {
            break label618;
          }
          i = paramEditable.charAt(j);
          localObject3 = as.GiG;
          if (i != as.ffM()) {
            break label618;
          }
          ((h)localObject1).EUg = j;
          localObject3 = ((h)localObject1).EUa;
          if (localObject3 != null) {
            ((LinearLayout)localObject3).setVisibility(0);
          }
          localObject3 = ((h)localObject1).dataList;
          if (localObject3 != null)
          {
            localObject4 = ((h)localObject1).EUf;
            if (localObject4 != null) {
              ((h.b)localObject4).setData((List)localObject3);
            }
          }
          localObject3 = ((h)localObject1).EUe;
          if (localObject3 != null) {
            ((a)localObject3).invoke();
          }
          h.a((h)localObject1);
        }
      }
      label209:
      int i = g.ej(this.ETd * 2, String.valueOf(paramEditable)) / 2;
      i = this.ETd - i;
      jdField_this.ESY = true;
      if (i / this.ETd >= 0.95D)
      {
        localObject1 = b.a(jdField_this);
        if (localObject1 == null)
        {
          s.bIx("textCountTv");
          localObject1 = null;
          label278:
          ((TextView)localObject1).setText((CharSequence)(i + '/' + this.ETd));
          if (i <= this.ETd) {
            break label877;
          }
          localTextView = b.a(jdField_this);
          localObject1 = localTextView;
          if (localTextView == null)
          {
            s.bIx("textCountTv");
            localObject1 = null;
          }
          ((TextView)localObject1).setTextColor(jdField_this.getResources().getColor(l.b.Red_100));
          jdField_this.ESY = false;
          label372:
          localObject1 = b.a(jdField_this);
          if (localObject1 != null) {
            break label924;
          }
          s.bIx("textCountTv");
          localObject1 = localObject2;
          label395:
          ((TextView)localObject1).setVisibility(0);
          localObject1 = jdField_this;
          localObject2 = com.tencent.mm.ui.component.k.aeZF;
          ((f)com.tencent.mm.ui.component.k.d(((b)localObject1).getActivity()).q(f.class)).eHt();
          localObject1 = jdField_this.eHc();
          localObject2 = String.valueOf(paramEditable);
          s.checkNotNull(paramEditable);
          ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).a((String)localObject2, paramEditable);
          paramEditable = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (com.tencent.mm.plugin.finder.storage.d.eRs())
          {
            i = jdField_this.eHc().fma().GId.size();
            paramEditable = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (i <= ((Number)com.tencent.mm.plugin.finder.storage.d.eSo().bmg()).intValue()) {
              break label999;
            }
            jdField_this.eHa().uV(false);
          }
        }
      }
      for (;;)
      {
        paramEditable = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (!com.tencent.mm.plugin.finder.storage.d.eRt()) {
          break label1024;
        }
        paramEditable = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eSF().bmg()).intValue() == 1000) {
          break label1013;
        }
        i = jdField_this.eHc().fmb().Gct.size();
        paramEditable = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (i < ((Number)com.tencent.mm.plugin.finder.storage.d.eSF().bmg()).intValue()) {
          break label1013;
        }
        jdField_this.eHa().uW(false);
        AppMethodBeat.o(349567);
        return;
        label604:
        i = ((b)localObject1).selectionStart;
        break;
        label613:
        i = 0;
        break label105;
        label618:
        i = ((h)localObject1).EUg;
        if (i >= 0) {
          if (i < j)
          {
            i = 1;
            if ((i == 0) || (((h)localObject1).EUg + 1 >= paramEditable.length()) || (j + 1 > paramEditable.length())) {
              break label866;
            }
            localObject3 = new char[j - ((h)localObject1).EUg];
            paramEditable.getChars(((h)localObject1).EUg + 1, j + 1, (char[])localObject3, 0);
            ((h)localObject1).EUh = new String((char[])localObject3);
            localObject3 = ((h)localObject1).dataList;
            if (localObject3 == null) {
              break label209;
            }
            localObject4 = (Iterable)localObject3;
            localObject3 = (Collection)new ArrayList();
            localObject4 = ((Iterable)localObject4).iterator();
          }
        }
        label835:
        for (;;)
        {
          label751:
          if (!((Iterator)localObject4).hasNext()) {
            break label837;
          }
          Object localObject5 = ((Iterator)localObject4).next();
          String str = ((bxv)localObject5).topic;
          if (str == null) {}
          for (boolean bool = false;; bool = n.i((CharSequence)str, (CharSequence)((h)localObject1).EUh))
          {
            if (!bool) {
              break label835;
            }
            ((Collection)localObject3).add(localObject5);
            break label751;
            i = 0;
            break;
            i = 0;
            break;
          }
        }
        label837:
        localObject3 = (List)localObject3;
        localObject1 = ((h)localObject1).EUf;
        if (localObject1 == null) {
          break label209;
        }
        ((h.b)localObject1).setData((List)localObject3);
        break label209;
        label866:
        ((h)localObject1).eHA();
        break label209;
        break label278;
        label877:
        localTextView = b.a(jdField_this);
        localObject1 = localTextView;
        if (localTextView == null)
        {
          s.bIx("textCountTv");
          localObject1 = null;
        }
        ((TextView)localObject1).setTextColor(jdField_this.getResources().getColor(l.b.FG_1));
        break label372;
        label924:
        break label395;
        localObject1 = b.a(jdField_this);
        if (localObject1 == null)
        {
          s.bIx("textCountTv");
          localObject1 = null;
          label949:
          ((TextView)localObject1).setText((CharSequence)"");
          localObject1 = b.a(jdField_this);
          if (localObject1 != null) {
            break label996;
          }
          s.bIx("textCountTv");
          localObject1 = localTextView;
        }
        label996:
        for (;;)
        {
          ((TextView)localObject1).setVisibility(8);
          break;
          break label949;
        }
        label999:
        jdField_this.eHa().uV(true);
      }
      label1013:
      jdField_this.eHa().uW(true);
      label1024:
      AppMethodBeat.o(349567);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "topic", "", "inputTopicStr"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<String, String, ah>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<c>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ScrollView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ScrollView>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.post.b
 * JD-Core Version:    0.7.0.1
 */