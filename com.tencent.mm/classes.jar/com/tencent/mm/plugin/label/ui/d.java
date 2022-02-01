package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.ax.a;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/HeaderLabelDataItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "labelString", "", "(ILjava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "headerLabelViewHolder", "Lcom/tencent/mm/plugin/label/ui/HeaderLabelDataItem$HeaderLabelViewHolder;", "headerViewItem", "Lcom/tencent/mm/plugin/label/ui/HeaderLabelDataItem$HeaderLabelViewItem;", "getLabelString", "setLabelString", "(Ljava/lang/String;)V", "mMaxInputCount", "mMaxShowCount", "mShowVibrate", "", "mSpannSize", "Ljava/lang/Integer;", "mText", "textListener", "Lcom/tencent/mm/plugin/label/ui/HeaderLabelDataItem$OnEditTextChangedListener;", "createViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "fillingDataItem", "", "context", "Landroid/content/Context;", "baseViewHolder", "getViewItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "setEditTextListener", "setShowVibrate", "showVibrate", "HeaderLabelViewHolder", "HeaderLabelViewItem", "OnEditTextChangedListener", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.ui.contact.a.a
{
  String JWV;
  private final b JWW;
  private final int JWX;
  private final int JWY;
  final a JWZ;
  c JXa;
  private Integer JXb;
  boolean JXc;
  private final String TAG;
  private String mText;
  
  public d(int paramInt, String paramString)
  {
    super(1, paramInt);
    AppMethodBeat.i(268749);
    this.JWV = paramString;
    this.TAG = "MicroMsg.Label.HeaderLabelDataItem";
    this.JWW = new b();
    this.JWX = 36;
    this.JWZ = new a();
    this.mText = " ";
    this.JXb = Integer.valueOf(0);
    AppMethodBeat.o(268749);
  }
  
  public final void a(Context paramContext, a.a parama) {}
  
  public final a.b bVv()
  {
    return (a.b)this.JWW;
  }
  
  public final a.a bVw()
  {
    return (a.a)this.JWZ;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/HeaderLabelDataItem$HeaderLabelViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/label/ui/HeaderLabelDataItem;)V", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "mDeleteBtn", "Landroid/widget/ImageView;", "getMDeleteBtn", "()Landroid/widget/ImageView;", "setMDeleteBtn", "(Landroid/widget/ImageView;)V", "mErrorMsgTextView", "Landroid/widget/TextView;", "getMErrorMsgTextView", "()Landroid/widget/TextView;", "setMErrorMsgTextView", "(Landroid/widget/TextView;)V", "checkInputSize", "", "input", "", "setFilter", "setText", "text", "showErrorMsg", "flag", "", "maxinput", "", "overcount", "showInvaildMsg", "MMInputFilter", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends a.a
  {
    public MMEditText GBE;
    public ImageView JXd;
    public TextView JXe;
    
    public a()
    {
      super();
      AppMethodBeat.i(268801);
      AppMethodBeat.o(268801);
    }
    
    public final TextView fTA()
    {
      AppMethodBeat.i(268821);
      TextView localTextView = this.JXe;
      if (localTextView != null)
      {
        AppMethodBeat.o(268821);
        return localTextView;
      }
      s.bIx("mErrorMsgTextView");
      AppMethodBeat.o(268821);
      return null;
    }
    
    public final ImageView fTz()
    {
      AppMethodBeat.i(268815);
      ImageView localImageView = this.JXd;
      if (localImageView != null)
      {
        AppMethodBeat.o(268815);
        return localImageView;
      }
      s.bIx("mDeleteBtn");
      AppMethodBeat.o(268815);
      return null;
    }
    
    public final MMEditText getEditText()
    {
      AppMethodBeat.i(268806);
      MMEditText localMMEditText = this.GBE;
      if (localMMEditText != null)
      {
        AppMethodBeat.o(268806);
        return localMMEditText;
      }
      s.bIx("editText");
      AppMethodBeat.o(268806);
      return null;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/HeaderLabelDataItem$HeaderLabelViewHolder$MMInputFilter;", "Landroid/text/InputFilter;", "(Lcom/tencent/mm/plugin/label/ui/HeaderLabelDataItem$HeaderLabelViewHolder;)V", "SECOND_INVAILD_CHAR", "", "getSECOND_INVAILD_CHAR", "()[C", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class a
      implements InputFilter
    {
      private final char[] JXg;
      
      public a()
      {
        AppMethodBeat.i(268638);
        this.JXg = new char[] { '\n', ',', ';', '、', 65292, 65307 };
        AppMethodBeat.o(268638);
      }
      
      public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
      {
        AppMethodBeat.i(268640);
        s.u(paramCharSequence, "source");
        s.u(paramSpanned, "dest");
        int j;
        int m;
        int i;
        if (paramInt1 < paramInt2)
        {
          paramInt4 = paramInt1;
          j = paramInt4 + 1;
          paramSpanned = new char[paramInt2 - paramInt1];
          TextUtils.getChars(paramCharSequence, paramInt1, paramInt2, paramSpanned, 0);
          m = this.JXg.length;
          i = 0;
          if (m <= 0) {}
        }
        for (;;)
        {
          int k = i + 1;
          if ((paramSpanned[paramInt4] == ' ') && (paramInt3 == 0) && (paramInt4 == 0))
          {
            paramCharSequence = (CharSequence)"";
            AppMethodBeat.o(268640);
            return paramCharSequence;
          }
          if (paramSpanned[paramInt4] == this.JXg[i])
          {
            paramCharSequence = this.JXh;
            if (paramCharSequence.fTA() != null)
            {
              paramCharSequence.fTA().setVisibility(8);
              paramSpanned = ax.adKR;
              ax.a.jlo();
              Toast.makeText(paramCharSequence.fTA().getContext(), (CharSequence)paramCharSequence.fTA().getContext().getString(R.l.gpJ), 0).show();
            }
            paramCharSequence = (CharSequence)"";
            AppMethodBeat.o(268640);
            return paramCharSequence;
          }
          if (k >= m)
          {
            if (j >= paramInt2)
            {
              AppMethodBeat.o(268640);
              return null;
            }
            paramInt4 = j;
            break;
          }
          i = k;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/HeaderLabelDataItem$HeaderLabelViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/label/ui/HeaderLabelDataItem;)V", "fillingViewItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "data", "alwaysCheck", "", "isCheck", "inflateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "convertView", "onItemClick", "v", "setHolderView", "Lcom/tencent/mm/plugin/label/ui/HeaderLabelDataItem$HeaderLabelViewHolder;", "Lcom/tencent/mm/plugin/label/ui/HeaderLabelDataItem;", "view", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends a.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(268809);
      AppMethodBeat.o(268809);
    }
    
    private static final void a(d.a parama)
    {
      AppMethodBeat.i(268819);
      s.u(parama, "$holder");
      if (parama.getEditText() != null)
      {
        Object localObject = parama.getEditText().getContext().getSystemService("input_method");
        if (localObject == null)
        {
          parama = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
          AppMethodBeat.o(268819);
          throw parama;
        }
        ((InputMethodManager)localObject).showSoftInput((View)parama.getEditText(), 0);
        parama.getEditText().setCursorVisible(false);
        parama.getEditText().setCursorVisible(true);
      }
      AppMethodBeat.o(268819);
    }
    
    private static final void a(d.a parama, d paramd, View paramView)
    {
      AppMethodBeat.i(268825);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(parama);
      localb.cH(paramd);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/HeaderLabelDataItem$HeaderLabelViewItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "$holder");
      s.u(paramd, "this$0");
      if (parama.getEditText() != null)
      {
        parama.getEditText().setText((CharSequence)" ");
        localObject = d.a(paramd);
        paramView = (View)localObject;
        if (localObject == null)
        {
          s.bIx("textListener");
          paramView = null;
        }
        paramView.aJN("");
        d.a(paramd, " ");
      }
      if (parama.fTA().getVisibility() == 0) {
        parama.fTA().setVisibility(8);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/label/ui/HeaderLabelDataItem$HeaderLabelViewItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(268825);
    }
    
    private static final boolean a(d.a parama, View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(268829);
      s.u(parama, "$holder");
      if (parama.getEditText() != null) {
        parama.getEditText().clearFocus();
      }
      AppMethodBeat.o(268829);
      return false;
    }
    
    public final View a(Context paramContext, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(268857);
      paramContext = LayoutInflater.from(paramContext).inflate(R.i.gmc, paramViewGroup, false);
      paramViewGroup = (d.a)this.JXf.JWZ;
      s.checkNotNull(paramContext);
      s.u(paramViewGroup, "holder");
      s.u(paramContext, "view");
      Object localObject1 = paramContext.findViewById(R.h.edittext);
      s.s(localObject1, "view.findViewById(R.id.edittext)");
      localObject1 = (MMEditText)localObject1;
      s.u(localObject1, "<set-?>");
      paramViewGroup.GBE = ((MMEditText)localObject1);
      d.a(this.JXf, Integer.valueOf(com.tencent.mm.cd.a.br(paramViewGroup.getEditText().getContext(), R.f.HintTextSize)));
      localObject1 = paramContext.findViewById(R.h.fEU);
      s.s(localObject1, "view.findViewById(R.id.delete)");
      localObject1 = (ImageView)localObject1;
      s.u(localObject1, "<set-?>");
      paramViewGroup.JXd = ((ImageView)localObject1);
      localObject1 = paramContext.findViewById(R.h.fGO);
      s.s(localObject1, "view.findViewById(R.id.err_msg)");
      localObject1 = (TextView)localObject1;
      s.u(localObject1, "<set-?>");
      paramViewGroup.JXe = ((TextView)localObject1);
      if (paramViewGroup.getEditText() != null)
      {
        if (d.d(paramViewGroup.JXf) <= 0) {
          break label451;
        }
        paramViewGroup.getEditText().setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(d.d(paramViewGroup.JXf)), (InputFilter)new d.a.a(paramViewGroup) });
      }
      for (;;)
      {
        paramViewGroup.getEditText().requestFocus();
        paramViewGroup.getEditText().addTextChangedListener((TextWatcher)new a(this.JXf, paramViewGroup));
        new MMHandler().postDelayed(new d.b..ExternalSyntheticLambda2(paramViewGroup), 0L);
        paramViewGroup.fTz().setOnClickListener(new d.b..ExternalSyntheticLambda0(paramViewGroup, this.JXf));
        if (paramViewGroup.fTA() != null) {
          paramViewGroup.fTA().setOnTouchListener(new d.b..ExternalSyntheticLambda1(paramViewGroup));
        }
        Object localObject2 = this.JXf.JWV;
        s.u(localObject2, "text");
        d.a(paramViewGroup.JXf, (String)localObject2);
        if ((paramViewGroup.getEditText() != null) && (!Util.isNullOrNil((String)localObject2)))
        {
          localObject1 = paramViewGroup.getEditText().getContext();
          localObject2 = (CharSequence)localObject2;
          Integer localInteger = d.c(paramViewGroup.JXf);
          s.checkNotNull(localInteger);
          localObject1 = p.d((Context)localObject1, (CharSequence)localObject2, localInteger.intValue());
          s.s(localObject1, "spanForSmiley(editText.g…xt(), text, mSpannSize!!)");
          paramViewGroup.getEditText().setText((CharSequence)localObject1);
        }
        paramViewGroup.getEditText().setHint((CharSequence)paramViewGroup.getEditText().getContext().getString(R.l.gMi));
        paramContext.setTag(paramViewGroup);
        AppMethodBeat.o(268857);
        return paramContext;
        label451:
        paramViewGroup.getEditText().setFilters(new InputFilter[] { (InputFilter)new d.a.a(paramViewGroup) });
      }
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.ui.contact.a.a parama)
    {
      return false;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/HeaderLabelDataItem$HeaderLabelViewItem$setHolderView$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements TextWatcher
    {
      a(d paramd, d.a parama) {}
      
      public final void afterTextChanged(Editable paramEditable)
      {
        int i = 8;
        AppMethodBeat.i(268736);
        if (paramEditable != null)
        {
          String str = paramEditable.toString();
          paramEditable = paramViewGroup.fTz();
          if (Util.isNullOrNil(str)) {}
          for (;;)
          {
            paramEditable.setVisibility(i);
            paramViewGroup.getEditText().removeTextChangedListener((TextWatcher)this);
            paramEditable = str;
            if (Util.isNullOrNil(str)) {
              break label263;
            }
            i = g.bCx(str);
            g.ek(d.b(this.JXf), str);
            paramEditable = str;
            if (i <= d.b(this.JXf)) {
              break label263;
            }
            i = g.ei(d.b(this.JXf), str);
            paramEditable = str;
            if (i <= 0) {
              break label263;
            }
            paramEditable = str;
            if (i >= d.b(this.JXf)) {
              break label263;
            }
            paramEditable = str;
            if (i >= str.length()) {
              break label263;
            }
            if (str != null) {
              break;
            }
            paramEditable = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(268736);
            throw paramEditable;
            i = 0;
          }
          str = str.substring(0, i + 1);
          s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          paramViewGroup.getEditText().setText((CharSequence)str);
          paramViewGroup.getEditText().setSelection(paramViewGroup.getEditText().getText().length());
          paramEditable = ax.adKR;
          ax.a.jlo();
          Context localContext = paramViewGroup.getEditText().getContext();
          paramEditable = paramViewGroup.getEditText().getContext();
          if (paramEditable == null) {}
          for (paramEditable = null;; paramEditable = paramEditable.getString(R.l.label_text_max_input, new Object[] { Integer.valueOf(d.b(this.JXf) / 2) }))
          {
            Toast.makeText(localContext, (CharSequence)paramEditable, 0).show();
            paramEditable = str;
            label263:
            d.a(this.JXf, paramEditable);
            paramViewGroup.getEditText().addTextChangedListener((TextWatcher)this);
            paramViewGroup.getEditText().setSelection(paramViewGroup.getEditText().getText().length());
            AppMethodBeat.o(268736);
            return;
          }
        }
        paramViewGroup.fTz().setVisibility(8);
        AppMethodBeat.o(268736);
      }
      
      public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
      
      public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
      {
        AppMethodBeat.i(268728);
        d.c localc2 = d.a(this.JXf);
        d.c localc1 = localc2;
        if (localc2 == null)
        {
          s.bIx("textListener");
          localc1 = null;
        }
        localc1.aJN(String.valueOf(paramCharSequence));
        AppMethodBeat.o(268728);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/HeaderLabelDataItem$OnEditTextChangedListener;", "", "OnEditTextChanged", "", "Str", "", "enableSaveBtn", "enable", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void aJN(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.d
 * JD-Core Version:    0.7.0.1
 */