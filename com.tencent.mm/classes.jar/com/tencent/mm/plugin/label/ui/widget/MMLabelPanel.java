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
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.d;
import com.tencent.mm.ui.tools.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MMLabelPanel
  extends MMTagPanel
{
  private boolean Eft;
  private boolean Efu;
  private MMTagPanel.d Efv;
  private MMTagPanel.d Efw;
  private int Efx;
  private a Efy;
  private a Efz;
  public Context mContext;
  
  public MMLabelPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(286071);
    this.Eft = false;
    this.Efu = false;
    this.Efx = 200;
    bv(paramContext);
    AppMethodBeat.o(286071);
  }
  
  public MMLabelPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(286073);
    this.Eft = false;
    this.Efu = false;
    this.Efx = 200;
    bv(paramContext);
    AppMethodBeat.o(286073);
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(286074);
    this.mContext = paramContext;
    eLs();
    eLt();
    ho(paramContext);
    AppMethodBeat.o(286074);
  }
  
  private void eLs()
  {
    AppMethodBeat.i(286078);
    this.Efv = hKd();
    View localView = LayoutInflater.from(getContext()).inflate(R.i.eft, null);
    ImageView localImageView = (ImageView)localView.findViewById(R.h.dHV);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(280268);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/widget/MMLabelPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (MMLabelPanel.a(MMLabelPanel.this) != null)
        {
          paramAnonymousView = MMLabelPanel.a(MMLabelPanel.this);
          MMLabelPanel.b(MMLabelPanel.this);
          paramAnonymousView.eLr();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/widget/MMLabelPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(280268);
      }
    });
    if (this.Efv != null) {
      localImageView.setImageDrawable(au.o(this.mContext, R.k.icons_outlined_more, com.tencent.mm.ci.a.w(getContext(), R.e.BW_70)));
    }
    this.Efv.WmT.setText("");
    this.Efv.bFK = localView;
    AppMethodBeat.o(286078);
  }
  
  private void eLt()
  {
    AppMethodBeat.i(286079);
    this.Efw = hKd();
    View localView = LayoutInflater.from(getContext()).inflate(R.i.efs, null);
    ((ImageView)localView.findViewById(R.h.dNq)).setImageDrawable(au.o(this.mContext, R.k.icons_filled_add, com.tencent.mm.ci.a.w(getContext(), R.e.BW_70)));
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(285313);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/widget/MMLabelPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (MMLabelPanel.c(MMLabelPanel.this) != null)
        {
          paramAnonymousView = MMLabelPanel.c(MMLabelPanel.this);
          MMLabelPanel.d(MMLabelPanel.this);
          paramAnonymousView.eLr();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/widget/MMLabelPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(285313);
      }
    });
    this.Efw.bFK = localView;
    this.Efv.WmT.setText("");
    AppMethodBeat.o(286079);
  }
  
  private void ho(Context paramContext)
  {
    AppMethodBeat.i(286086);
    setTagNormalBG(R.g.doZ);
    setTagSelectedBG(R.g.dpa);
    setTagNormalTextColorRes(R.e.FG_2);
    setTagSelectedTextColorRes(R.e.dark_bg_blue_color);
    setHintTextSize(com.tencent.mm.ci.a.aZ(paramContext, R.f.dlz));
    AppMethodBeat.o(286086);
  }
  
  public final String a(EditText paramEditText, Editable paramEditable, String paramString, TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(286077);
    paramEditText.removeTextChangedListener(paramTextWatcher);
    if (this.WmF > 0)
    {
      if (paramEditable != null)
      {
        paramEditable = paramEditable.toString();
        if (!Util.isNullOrNil(paramEditable))
        {
          int i = g.bAB(paramEditable);
          g.dr(this.WmF, paramEditable);
          if (i > this.WmF)
          {
            i = g.dp(this.WmF, paramEditable);
            if ((i > 0) && (i < this.WmF) && (i < paramEditable.length()))
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
      AppMethodBeat.o(286077);
      return paramString;
    }
  }
  
  public final void a(Collection<String> paramCollection, List<String> paramList)
  {
    AppMethodBeat.i(286080);
    hJT();
    if (this.Wmr) {
      addView(this.WmD);
    }
    if (paramList == null)
    {
      if (this.Efu)
      {
        Log.i("MicroMsg.Label.MMLabelPanel", "setTagListByTagName, tags is null, needNewLebal.");
        addView(this.Efw.bFK);
      }
      AppMethodBeat.o(286080);
      return;
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (paramCollection == null) {}
      for (boolean bool = false;; bool = paramCollection.contains(str))
      {
        bR(str, bool);
        break;
      }
    }
    if (this.Efu)
    {
      Log.i("MicroMsg.Label.MMLabelPanel", "setTagListByTagName, needNewLebal.");
      addView(this.Efw.bFK);
    }
    if (this.Eft)
    {
      Log.i("MicroMsg.Label.MMLabelPanel", "setTagListByTagName, needGotoMorePage.");
      addView(this.Efv.bFK);
    }
    paramCollection = this.Crg.iterator();
    do
    {
      if (!paramCollection.hasNext()) {
        break;
      }
      paramList = (MMTagPanel.d)paramCollection.next();
    } while ((paramList == this.Efv) || (paramList == this.Efw));
    for (int i = 1;; i = 0)
    {
      if ((this.Eft) && (this.Efv.bFK != null))
      {
        if (i == 0)
        {
          Log.i("MicroMsg.Label.MMLabelPanel", "setTagListByTagName, tags.isEmpty.");
          this.Efv.bFK.setVisibility(8);
          AppMethodBeat.o(286080);
          return;
        }
        this.Efv.bFK.setVisibility(0);
      }
      AppMethodBeat.o(286080);
      return;
    }
  }
  
  public final void bR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(286075);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.Label.MMLabelPanel", "addTag, want to add tag, but it is null or empty");
      AppMethodBeat.o(286075);
      return;
    }
    paramString = paramString.trim();
    Log.d("MicroMsg.Label.MMLabelPanel", "addTag, want to add tag %s, do remove tag first", new Object[] { paramString });
    removeTag(paramString);
    Object localObject = this.Crg.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((MMTagPanel.d)((Iterator)localObject).next()).WmS))
      {
        Log.w("MicroMsg.Label.MMLabelPanel", "addTag, want to add tag %s, but it exsited!", new Object[] { paramString });
        AppMethodBeat.o(286075);
        return;
      }
    }
    localObject = hKd();
    a((MMTagPanel.d)localObject, paramString, paramBoolean);
    if (this.Wmr) {
      addView(((MMTagPanel.d)localObject).WmT, getChildCount() - 1);
    }
    for (;;)
    {
      this.Crg.add(localObject);
      hKe();
      AppMethodBeat.o(286075);
      return;
      addView(((MMTagPanel.d)localObject).WmT);
    }
  }
  
  public final void dmb()
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
  
  public final TextView eLu()
  {
    AppMethodBeat.i(286089);
    TextView localTextView = super.eLu();
    localTextView.setPadding(com.tencent.mm.ci.a.fromDPToPix(this.mContext, 12.0F), com.tencent.mm.ci.a.fromDPToPix(this.mContext, 5.0F), com.tencent.mm.ci.a.fromDPToPix(this.mContext, 12.0F), com.tencent.mm.ci.a.fromDPToPix(this.mContext, 6.0F));
    localTextView.setGravity(17);
    localTextView.setHeight(com.tencent.mm.ci.a.fromDPToPix(this.mContext, 32.0F));
    localTextView.setTextSize(0, com.tencent.mm.ci.a.aZ(this.mContext, R.f.dlz));
    AppMethodBeat.o(286089);
    return localTextView;
  }
  
  public final void eT(String paramString, int paramInt)
  {
    AppMethodBeat.i(286076);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.Label.MMLabelPanel", "addTag2, want to add tag, but it is null or empty");
      AppMethodBeat.o(286076);
      return;
    }
    paramString = paramString.trim();
    Log.d("MicroMsg.Label.MMLabelPanel", "addTag2,want to add tag %s, do remove tag first", new Object[] { paramString });
    removeTag(paramString);
    Object localObject = this.Crg.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((MMTagPanel.d)((Iterator)localObject).next()).WmS))
      {
        Log.w("MicroMsg.Label.MMLabelPanel", "addTag2,want to add tag %s, but it exsited!", new Object[] { paramString });
        AppMethodBeat.o(286076);
        return;
      }
    }
    localObject = hKd();
    a((MMTagPanel.d)localObject, paramString, true);
    addView(((MMTagPanel.d)localObject).WmT, paramInt);
    this.Crg.add(localObject);
    hKe();
    AppMethodBeat.o(286076);
  }
  
  public int getEditViewLayoutId()
  {
    return R.i.eiL;
  }
  
  public ArrayList<String> getSelectTagList()
  {
    AppMethodBeat.i(286082);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Crg.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if ((locald != null) && (locald != this.Efw) && (locald != this.Efv) && (!Util.isNullOrNil(locald.WmS)) && (locald.WmT != null) && (((Integer)locald.WmT.getTag()).intValue() == 1)) {
        localArrayList.add(locald.WmS);
      }
    }
    AppMethodBeat.o(286082);
    return localArrayList;
  }
  
  public ArrayList<String> getTagListWithIcon()
  {
    AppMethodBeat.i(286083);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Crg.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if ((!Util.isNullOrNil(locald.WmS)) && (locald != this.Efw) && (locald != this.Efv)) {
        localArrayList.add(locald.WmS);
      }
    }
    AppMethodBeat.o(286083);
    return localArrayList;
  }
  
  public void setClickDetailCallBack(a parama)
  {
    this.Efy = parama;
  }
  
  public void setClickNewLebalCallBack(a parama)
  {
    this.Efz = parama;
  }
  
  public void setMaxLineSize(int paramInt)
  {
    this.Efx = paramInt;
  }
  
  public void setNeedAddLastItemToMove(boolean paramBoolean)
  {
    this.Eft = paramBoolean;
  }
  
  public void setNeedNewLebal(boolean paramBoolean)
  {
    this.Efu = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void eLr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.MMLabelPanel
 * JD-Core Version:    0.7.0.1
 */