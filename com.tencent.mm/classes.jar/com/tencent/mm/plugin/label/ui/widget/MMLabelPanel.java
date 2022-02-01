package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.d;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.tools.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MMLabelPanel
  extends MMTagPanel
{
  private boolean JYK;
  private boolean JYL;
  private MMTagPanel.d JYM;
  private MMTagPanel.d JYN;
  private int JYO;
  private a JYP;
  private a JYQ;
  public Context mContext;
  
  public MMLabelPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(268781);
    this.JYK = false;
    this.JYL = false;
    this.JYO = 200;
    ci(paramContext);
    AppMethodBeat.o(268781);
  }
  
  public MMLabelPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(268786);
    this.JYK = false;
    this.JYL = false;
    this.JYO = 200;
    ci(paramContext);
    AppMethodBeat.o(268786);
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(268793);
    this.mContext = paramContext;
    fTK();
    fTL();
    iJ(paramContext);
    AppMethodBeat.o(268793);
  }
  
  private void fTK()
  {
    AppMethodBeat.i(268798);
    this.JYM = jmJ();
    View localView = LayoutInflater.from(getContext()).inflate(R.i.gio, null);
    ImageView localImageView = (ImageView)localView.findViewById(R.h.fJi);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(268772);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/widget/MMLabelPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (MMLabelPanel.a(MMLabelPanel.this) != null)
        {
          paramAnonymousView = MMLabelPanel.a(MMLabelPanel.this);
          MMLabelPanel.b(MMLabelPanel.this);
          paramAnonymousView.fTy();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/widget/MMLabelPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(268772);
      }
    });
    if (this.JYM != null) {
      localImageView.setImageDrawable(bb.m(this.mContext, R.k.icons_outlined_more, com.tencent.mm.cd.a.w(getContext(), R.e.BW_70)));
    }
    this.JYM.adUg.setText("");
    this.JYM.dyK = localView;
    AppMethodBeat.o(268798);
  }
  
  private void fTL()
  {
    AppMethodBeat.i(268804);
    this.JYN = jmJ();
    View localView = LayoutInflater.from(getContext()).inflate(R.i.gin, null);
    ((ImageView)localView.findViewById(R.h.fPr)).setImageDrawable(bb.m(this.mContext, R.k.icons_filled_add, com.tencent.mm.cd.a.w(getContext(), R.e.BW_70)));
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(268770);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/widget/MMLabelPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (MMLabelPanel.c(MMLabelPanel.this) != null)
        {
          paramAnonymousView = MMLabelPanel.c(MMLabelPanel.this);
          MMLabelPanel.d(MMLabelPanel.this);
          paramAnonymousView.fTy();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/widget/MMLabelPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(268770);
      }
    });
    this.JYN.dyK = localView;
    this.JYM.adUg.setText("");
    AppMethodBeat.o(268804);
  }
  
  private void iJ(Context paramContext)
  {
    AppMethodBeat.i(268811);
    setTagNormalBG(R.g.fpn);
    setTagSelectedBG(R.g.fpo);
    setTagNormalTextColorRes(R.e.FG_2);
    setTagSelectedTextColorRes(R.e.dark_bg_blue_color);
    setHintTextSize(com.tencent.mm.cd.a.bs(paramContext, R.f.flR));
    AppMethodBeat.o(268811);
  }
  
  public final String a(EditText paramEditText, Editable paramEditable, String paramString, TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(268860);
    paramEditText.removeTextChangedListener(paramTextWatcher);
    if (this.adTS > 0)
    {
      if (paramEditable != null)
      {
        paramEditable = paramEditable.toString();
        if (!Util.isNullOrNil(paramEditable))
        {
          int i = g.bCx(paramEditable);
          g.ek(this.adTS, paramEditable);
          if (i > this.adTS)
          {
            i = g.ei(this.adTS, paramEditable);
            if ((i > 0) && (i < this.adTS) && (i < paramEditable.length()))
            {
              paramEditText.setText(paramEditable.substring(0, i + 1));
              paramEditText.setSelection(paramEditText.getText().length());
            }
          }
        }
      }
      if (paramEditText.getText() == null) {
        break label145;
      }
    }
    label145:
    for (paramString = paramEditText.getText().toString();; paramString = "")
    {
      paramEditText.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(268860);
      return paramString;
    }
  }
  
  public final void a(Collection<String> paramCollection, List<String> paramList)
  {
    AppMethodBeat.i(268871);
    jmz();
    if (this.adTE) {
      addView(this.adTQ);
    }
    if (paramList == null)
    {
      if (this.JYL)
      {
        Log.i("MicroMsg.Label.MMLabelPanel", "setTagListByTagName, tags is null, needNewLebal.");
        addView(this.JYN.dyK);
      }
      AppMethodBeat.o(268871);
      return;
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (paramCollection == null) {}
      for (boolean bool = false;; bool = paramCollection.contains(str))
      {
        cm(str, bool);
        break;
      }
    }
    if (this.JYL)
    {
      Log.i("MicroMsg.Label.MMLabelPanel", "setTagListByTagName, needNewLebal.");
      addView(this.JYN.dyK);
    }
    if (this.JYK)
    {
      Log.i("MicroMsg.Label.MMLabelPanel", "setTagListByTagName, needGotoMorePage.");
      addView(this.JYM.dyK);
    }
    paramCollection = this.Idn.iterator();
    do
    {
      if (!paramCollection.hasNext()) {
        break;
      }
      paramList = (MMTagPanel.d)paramCollection.next();
    } while ((paramList == this.JYM) || (paramList == this.JYN));
    for (int i = 1;; i = 0)
    {
      if ((this.JYK) && (this.JYM.dyK != null))
      {
        if (i == 0)
        {
          Log.i("MicroMsg.Label.MMLabelPanel", "setTagListByTagName, tags.isEmpty.");
          this.JYM.dyK.setVisibility(8);
          AppMethodBeat.o(268871);
          return;
        }
        this.JYM.dyK.setVisibility(0);
      }
      AppMethodBeat.o(268871);
      return;
    }
  }
  
  public final void cm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(268845);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.Label.MMLabelPanel", "addTag, want to add tag, but it is null or empty");
      AppMethodBeat.o(268845);
      return;
    }
    paramString = paramString.trim();
    Log.d("MicroMsg.Label.MMLabelPanel", "addTag, want to add tag %s, do remove tag first", new Object[] { paramString });
    aue(paramString);
    Object localObject = this.Idn.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((MMTagPanel.d)((Iterator)localObject).next()).adUf))
      {
        Log.w("MicroMsg.Label.MMLabelPanel", "addTag, want to add tag %s, but it exsited!", new Object[] { paramString });
        AppMethodBeat.o(268845);
        return;
      }
    }
    localObject = jmJ();
    a((MMTagPanel.d)localObject, paramString, paramBoolean);
    if (this.adTE) {
      addView(((MMTagPanel.d)localObject).adUg, getChildCount() - 1);
    }
    for (;;)
    {
      this.Idn.add(localObject);
      jmK();
      AppMethodBeat.o(268845);
      return;
      addView(((MMTagPanel.d)localObject).adUg);
    }
  }
  
  public final void dSS()
  {
    AppMethodBeat.i(26338);
    Log.d("MicroMsg.Label.MMLabelPanel", "cpan[onPreDelTag]");
    if (getTagCount() > 0)
    {
      AppMethodBeat.o(26338);
      return;
    }
    AppMethodBeat.o(26338);
  }
  
  public final void fL(String paramString, int paramInt)
  {
    AppMethodBeat.i(268852);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.Label.MMLabelPanel", "addTag2, want to add tag, but it is null or empty");
      AppMethodBeat.o(268852);
      return;
    }
    paramString = paramString.trim();
    Log.d("MicroMsg.Label.MMLabelPanel", "addTag2,want to add tag %s, do remove tag first", new Object[] { paramString });
    aue(paramString);
    Object localObject = this.Idn.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((MMTagPanel.d)((Iterator)localObject).next()).adUf))
      {
        Log.w("MicroMsg.Label.MMLabelPanel", "addTag2,want to add tag %s, but it exsited!", new Object[] { paramString });
        AppMethodBeat.o(268852);
        return;
      }
    }
    localObject = jmJ();
    a((MMTagPanel.d)localObject, paramString, true);
    addView(((MMTagPanel.d)localObject).adUg, paramInt);
    this.Idn.add(localObject);
    jmK();
    AppMethodBeat.o(268852);
  }
  
  public final TextView fTM()
  {
    AppMethodBeat.i(268898);
    TextView localTextView = super.fTM();
    localTextView.setPadding(com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12.0F), com.tencent.mm.cd.a.fromDPToPix(this.mContext, 5.0F), com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12.0F), com.tencent.mm.cd.a.fromDPToPix(this.mContext, 6.0F));
    localTextView.setGravity(17);
    localTextView.setMinHeight(com.tencent.mm.cd.a.fromDPToPix(this.mContext, 32.0F));
    localTextView.setTextSize(0, com.tencent.mm.cd.a.bs(this.mContext, R.f.flR));
    AppMethodBeat.o(268898);
    return localTextView;
  }
  
  public int getEditViewLayoutId()
  {
    return R.i.glK;
  }
  
  public ArrayList<String> getSelectTagList()
  {
    AppMethodBeat.i(268877);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Idn.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if ((locald != null) && (locald != this.JYN) && (locald != this.JYM) && (!Util.isNullOrNil(locald.adUf)) && (locald.adUg != null) && (((Integer)locald.adUg.getTag()).intValue() == 1)) {
        localArrayList.add(locald.adUf);
      }
    }
    AppMethodBeat.o(268877);
    return localArrayList;
  }
  
  public ArrayList<String> getTagListWithIcon()
  {
    AppMethodBeat.i(268882);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Idn.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if ((!Util.isNullOrNil(locald.adUf)) && (locald != this.JYN) && (locald != this.JYM)) {
        localArrayList.add(locald.adUf);
      }
    }
    AppMethodBeat.o(268882);
    return localArrayList;
  }
  
  public void setClickDetailCallBack(a parama)
  {
    this.JYP = parama;
  }
  
  public void setClickNewLebalCallBack(a parama)
  {
    this.JYQ = parama;
  }
  
  public void setMaxLineSize(int paramInt)
  {
    this.JYO = paramInt;
  }
  
  public void setNeedAddLastItemToMove(boolean paramBoolean)
  {
    this.JYK = paramBoolean;
  }
  
  public void setNeedNewLebal(boolean paramBoolean)
  {
    this.JYL = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void fTy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.MMLabelPanel
 * JD-Core Version:    0.7.0.1
 */