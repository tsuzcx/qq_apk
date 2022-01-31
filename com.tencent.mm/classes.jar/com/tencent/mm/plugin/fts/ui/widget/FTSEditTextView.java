package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.fts.ui.n.b;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.e.c.b;
import com.tencent.mm.ui.tools.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FTSEditTextView
  extends LinearLayout
{
  private String frh;
  private ImageView gSx;
  private List<a.b> iSZ;
  public EditText kEp;
  private TextView kEq;
  private TextView kEr;
  private TextView kEs;
  private View kEt;
  private boolean kEu = true;
  private String kEv = "";
  private View.OnClickListener kEw = new FTSEditTextView.6(this);
  private FTSEditTextView.a kEx;
  private FTSEditTextView.b kEy = FTSEditTextView.b.kEB;
  public View.OnFocusChangeListener kEz = new FTSEditTextView.7(this);
  private ImageButton kjB;
  
  public FTSEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public FTSEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void aWz()
  {
    y.i("MicroMsg.FTS.FTSEditTextView", "updateTagView %s", new Object[] { Integer.valueOf(this.iSZ.size()) });
    float f = a.aa(getContext(), n.b.NormalTextSize);
    if (this.iSZ.size() > 0)
    {
      this.kEq.setVisibility(0);
      this.kEq.setText(b.d(getContext(), ((a.b)this.iSZ.get(0)).getTagName(), f));
      if (this.iSZ.size() < 2) {
        break label212;
      }
      this.kEr.setVisibility(0);
      this.kEr.setText(b.d(getContext(), ((a.b)this.iSZ.get(1)).getTagName(), f));
    }
    for (;;)
    {
      if (this.iSZ.size() < 3) {
        break label224;
      }
      this.kEs.setVisibility(0);
      this.kEs.setText(b.d(getContext(), ((a.b)this.iSZ.get(2)).getTagName(), f));
      return;
      this.kEq.setVisibility(8);
      break;
      label212:
      this.kEr.setVisibility(8);
    }
    label224:
    this.kEs.setVisibility(8);
  }
  
  public final void aWA()
  {
    this.gSx.setVisibility(8);
  }
  
  public final void aWB()
  {
    this.gSx.setVisibility(0);
  }
  
  public final void aWC()
  {
    this.kjB.setVisibility(8);
  }
  
  public final void aWD()
  {
    this.kjB.setVisibility(0);
  }
  
  public void aWw()
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(n.e.fts_edittext_view, this, true);
  }
  
  public final void aWx()
  {
    postDelayed(new FTSEditTextView.5(this), 128L);
  }
  
  public final void aWy()
  {
    this.kEp.requestFocus();
  }
  
  public final void clearText()
  {
    this.kEy = FTSEditTextView.b.kEC;
    if (this.kEu) {
      this.iSZ.clear();
    }
    this.kEp.setText("");
    this.kEp.setHint(this.frh);
    this.kjB.setVisibility(8);
    aWz();
    this.kEy = FTSEditTextView.b.kEB;
  }
  
  public ImageButton getClearBtn()
  {
    return this.kjB;
  }
  
  public EditText getEditText()
  {
    return this.kEp;
  }
  
  public int getHighlightColor()
  {
    return this.kEp.getHighlightColor();
  }
  
  public ImageView getIconView()
  {
    return this.gSx;
  }
  
  public String getInEditTextQuery()
  {
    return this.kEp.getText().toString().trim();
  }
  
  public List<a.b> getTagList()
  {
    return this.iSZ;
  }
  
  public View getTagPanel()
  {
    return this.kEt;
  }
  
  public FTSEditTextView.b getTextChangeStatus()
  {
    return this.kEy;
  }
  
  public String getTotalQuery()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.iSZ.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append(((a.b)localIterator.next()).getTagName());
      localStringBuffer.append(" ");
    }
    localStringBuffer.append(this.kEp.getText().toString());
    return localStringBuffer.toString().trim();
  }
  
  public void init()
  {
    aWw();
    this.kEt = findViewById(n.d.tag_panel);
    this.gSx = ((ImageView)findViewById(n.d.icon));
    this.kEp = ((EditText)findViewById(n.d.edittext));
    this.kjB = ((ImageButton)findViewById(n.d.clear_btn));
    this.kEq = ((TextView)findViewById(n.d.tag_1));
    this.kEr = ((TextView)findViewById(n.d.tag_2));
    this.kEs = ((TextView)findViewById(n.d.tag_3));
    this.iSZ = new ArrayList();
    this.kEp.setOnKeyListener(new FTSEditTextView.1(this));
    this.kEp.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousCharSequence = FTSEditTextView.this.getTotalQuery();
        if ((paramAnonymousCharSequence != FTSEditTextView.f(FTSEditTextView.this)) && (!paramAnonymousCharSequence.equals(FTSEditTextView.f(FTSEditTextView.this))))
        {
          FTSEditTextView.a(FTSEditTextView.this, paramAnonymousCharSequence);
          if (paramAnonymousCharSequence.length() <= 0) {
            break label68;
          }
          FTSEditTextView.g(FTSEditTextView.this).setVisibility(0);
        }
        for (;;)
        {
          FTSEditTextView.e(FTSEditTextView.this);
          return;
          label68:
          FTSEditTextView.g(FTSEditTextView.this).setVisibility(8);
        }
      }
    });
    this.kEp.setOnFocusChangeListener(this.kEz);
    this.kEp.setOnEditorActionListener(new FTSEditTextView.3(this));
    this.kEq.setOnClickListener(this.kEw);
    this.kEr.setOnClickListener(this.kEw);
    this.kEs.setOnClickListener(this.kEw);
    this.kjB.setOnClickListener(new FTSEditTextView.4(this));
    c.d(this.kEp).Ig(100).a(null);
  }
  
  public final void n(String paramString, List<a.b> paramList)
  {
    FTSEditTextView.b localb = FTSEditTextView.b.kEB;
    this.iSZ.clear();
    if (paramList != null) {
      this.iSZ.addAll(paramList);
    }
    y.i("MicroMsg.FTS.FTSEditTextView", "setText: %s %d", new Object[] { paramString, Integer.valueOf(this.iSZ.size()) });
    this.kEy = FTSEditTextView.b.kED;
    this.kEp.setText(paramString);
    Selection.setSelection(this.kEp.getText(), this.kEp.getText().length());
    aWz();
    this.kEy = localb;
  }
  
  public void setCanDeleteTag(boolean paramBoolean)
  {
    this.kEu = paramBoolean;
  }
  
  public void setFtsEditTextListener(FTSEditTextView.a parama)
  {
    this.kEx = parama;
  }
  
  public void setHint(String paramString)
  {
    this.kEp.setHint(paramString);
    this.frh = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView
 * JD-Core Version:    0.7.0.1
 */