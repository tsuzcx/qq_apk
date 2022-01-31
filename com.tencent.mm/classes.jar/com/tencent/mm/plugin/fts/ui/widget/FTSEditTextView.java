package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.f.c.b;
import com.tencent.mm.ui.tools.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FTSEditTextView
  extends LinearLayout
{
  private String hint;
  private ImageView ivs;
  private List<a.c> lbK;
  private ImageButton mEh;
  public EditText naN;
  private TextView naO;
  private TextView naP;
  private TextView naQ;
  private View naR;
  private boolean naS;
  private String naT;
  private View.OnClickListener naU;
  private FTSEditTextView.a naV;
  private FTSEditTextView.b naW;
  protected View.OnFocusChangeListener naX;
  
  public FTSEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(62115);
    this.naS = true;
    this.naT = "";
    this.naU = new FTSEditTextView.6(this);
    this.naW = FTSEditTextView.b.naZ;
    this.naX = new FTSEditTextView.7(this);
    init();
    AppMethodBeat.o(62115);
  }
  
  public FTSEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(62116);
    this.naS = true;
    this.naT = "";
    this.naU = new FTSEditTextView.6(this);
    this.naW = FTSEditTextView.b.naZ;
    this.naX = new FTSEditTextView.7(this);
    init();
    AppMethodBeat.o(62116);
  }
  
  private void a(String paramString, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(62124);
    this.lbK.clear();
    if (paramList != null) {
      this.lbK.addAll(paramList);
    }
    ab.i("MicroMsg.FTS.FTSEditTextView", "setText: %s %d", new Object[] { paramString, Integer.valueOf(this.lbK.size()) });
    this.naW = FTSEditTextView.b.nbb;
    this.naN.setText(paramString);
    Selection.setSelection(this.naN.getText(), this.naN.getText().length());
    bDg();
    this.naW = paramb;
    AppMethodBeat.o(62124);
  }
  
  private void bDg()
  {
    AppMethodBeat.i(62127);
    ab.i("MicroMsg.FTS.FTSEditTextView", "updateTagView %s", new Object[] { Integer.valueOf(this.lbK.size()) });
    float f = a.ao(getContext(), 2131427809);
    if (this.lbK.size() > 0)
    {
      this.naO.setVisibility(0);
      this.naO.setText(b.c(getContext(), ((a.c)this.lbK.get(0)).getTagName(), f));
      if (this.lbK.size() < 2) {
        break label221;
      }
      this.naP.setVisibility(0);
      this.naP.setText(b.c(getContext(), ((a.c)this.lbK.get(1)).getTagName(), f));
    }
    for (;;)
    {
      if (this.lbK.size() < 3) {
        break label233;
      }
      this.naQ.setVisibility(0);
      this.naQ.setText(b.c(getContext(), ((a.c)this.lbK.get(2)).getTagName(), f));
      AppMethodBeat.o(62127);
      return;
      this.naO.setVisibility(8);
      break;
      label221:
      this.naP.setVisibility(8);
    }
    label233:
    this.naQ.setVisibility(8);
    AppMethodBeat.o(62127);
  }
  
  protected void bDd()
  {
    AppMethodBeat.i(62117);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2130969656, this, true);
    AppMethodBeat.o(62117);
  }
  
  public final void bDe()
  {
    AppMethodBeat.i(62121);
    postDelayed(new FTSEditTextView.5(this), 128L);
    AppMethodBeat.o(62121);
  }
  
  public final void bDf()
  {
    AppMethodBeat.i(62125);
    this.naN.requestFocus();
    AppMethodBeat.o(62125);
  }
  
  public final void bDh()
  {
    AppMethodBeat.i(62130);
    this.ivs.setVisibility(8);
    AppMethodBeat.o(62130);
  }
  
  public final void bDi()
  {
    AppMethodBeat.i(62131);
    this.ivs.setVisibility(0);
    AppMethodBeat.o(62131);
  }
  
  public final void bDj()
  {
    AppMethodBeat.i(62132);
    this.mEh.setVisibility(8);
    AppMethodBeat.o(62132);
  }
  
  public final void bDk()
  {
    AppMethodBeat.i(62133);
    this.mEh.setVisibility(0);
    AppMethodBeat.o(62133);
  }
  
  public final void clearText()
  {
    AppMethodBeat.i(62119);
    this.naW = FTSEditTextView.b.nba;
    if (this.naS) {
      this.lbK.clear();
    }
    this.naN.setText("");
    this.naN.setHint(this.hint);
    this.mEh.setVisibility(8);
    bDg();
    this.naW = FTSEditTextView.b.naZ;
    AppMethodBeat.o(62119);
  }
  
  public ImageButton getClearBtn()
  {
    return this.mEh;
  }
  
  public EditText getEditText()
  {
    return this.naN;
  }
  
  public int getHighlightColor()
  {
    AppMethodBeat.i(62122);
    int i = this.naN.getHighlightColor();
    AppMethodBeat.o(62122);
    return i;
  }
  
  public ImageView getIconView()
  {
    return this.ivs;
  }
  
  public String getInEditTextQuery()
  {
    AppMethodBeat.i(62128);
    String str = this.naN.getText().toString().trim();
    AppMethodBeat.o(62128);
    return str;
  }
  
  public List<a.c> getTagList()
  {
    return this.lbK;
  }
  
  public View getTagPanel()
  {
    return this.naR;
  }
  
  public FTSEditTextView.b getTextChangeStatus()
  {
    return this.naW;
  }
  
  public String getTotalQuery()
  {
    AppMethodBeat.i(62129);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.lbK.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append(((a.c)localIterator.next()).getTagName());
      ((StringBuffer)localObject).append(" ");
    }
    ((StringBuffer)localObject).append(this.naN.getText().toString());
    localObject = ((StringBuffer)localObject).toString().trim();
    AppMethodBeat.o(62129);
    return localObject;
  }
  
  protected void init()
  {
    AppMethodBeat.i(62118);
    bDd();
    this.naR = findViewById(2131824345);
    this.ivs = ((ImageView)findViewById(2131820929));
    this.naN = ((EditText)findViewById(2131820995));
    this.mEh = ((ImageButton)findViewById(2131820991));
    this.naO = ((TextView)findViewById(2131824346));
    this.naP = ((TextView)findViewById(2131824347));
    this.naQ = ((TextView)findViewById(2131824348));
    this.lbK = new ArrayList();
    this.naN.setOnKeyListener(new FTSEditTextView.1(this));
    this.naN.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(62106);
        paramAnonymousCharSequence = FTSEditTextView.this.getTotalQuery();
        if ((paramAnonymousCharSequence != FTSEditTextView.f(FTSEditTextView.this)) && (!paramAnonymousCharSequence.equals(FTSEditTextView.f(FTSEditTextView.this))))
        {
          FTSEditTextView.a(FTSEditTextView.this, paramAnonymousCharSequence);
          if (paramAnonymousCharSequence.length() <= 0) {
            break label78;
          }
          FTSEditTextView.g(FTSEditTextView.this).setVisibility(0);
        }
        for (;;)
        {
          FTSEditTextView.e(FTSEditTextView.this);
          AppMethodBeat.o(62106);
          return;
          label78:
          FTSEditTextView.g(FTSEditTextView.this).setVisibility(8);
        }
      }
    });
    this.naN.setOnFocusChangeListener(this.naX);
    this.naN.setOnEditorActionListener(new FTSEditTextView.3(this));
    this.naO.setOnClickListener(this.naU);
    this.naP.setOnClickListener(this.naU);
    this.naQ.setOnClickListener(this.naU);
    this.mEh.setOnClickListener(new FTSEditTextView.4(this));
    c.d(this.naN).QS(100).a(null);
    AppMethodBeat.o(62118);
  }
  
  public final void o(String paramString, List<a.c> paramList)
  {
    AppMethodBeat.i(62123);
    a(paramString, paramList, FTSEditTextView.b.naZ);
    AppMethodBeat.o(62123);
  }
  
  public void setCanDeleteTag(boolean paramBoolean)
  {
    this.naS = paramBoolean;
  }
  
  public void setEditTextDrawableLeft(int paramInt)
  {
    AppMethodBeat.i(62120);
    if (paramInt == -1)
    {
      this.naN.setCompoundDrawablesRelative(null, null, null, null);
      AppMethodBeat.o(62120);
      return;
    }
    Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, a.fromDPToPix(getContext(), 15), a.fromDPToPix(getContext(), 15));
    this.naN.setCompoundDrawablesRelative(localDrawable, null, null, null);
    AppMethodBeat.o(62120);
  }
  
  public void setFtsEditTextListener(FTSEditTextView.a parama)
  {
    this.naV = parama;
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(62126);
    this.naN.setHint(paramString);
    this.hint = paramString;
    AppMethodBeat.o(62126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView
 * JD-Core Version:    0.7.0.1
 */