package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FTSSayFooter
  extends KeyboardLinearLayout
{
  public MMActivity bER;
  private int kET = -1;
  public FTSVoiceInputLayoutImpl kEU;
  public FTSSayFooter.a kEV = null;
  public ImageButton kEW;
  private b kEX;
  private VoiceInputLayout.b kEY = new FTSSayFooter.2(this);
  private Toast kEZ;
  private VoiceInputLayout.a kFa = new FTSSayFooter.3(this);
  private FTSVoiceInputLayoutImpl.a kFb = new FTSSayFooter.4(this);
  
  public FTSSayFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    this.kEW = ((ImageButton)((ViewGroup)y.gt(this.bER).inflate(n.e.fts_say_footer, this)).findViewById(n.d.album_comment_mode_iv));
    this.kEW.setOnClickListener(new FTSSayFooter.1(this));
    this.kEU = new FTSVoiceInputLayoutImpl(getContext());
    this.kEU.setVoiceDetectListener(this.kEY);
    this.kEU.setLongClickLisnter(this.kFa);
    this.kEU.setCloseListener(this.kFb);
    paramContext = (LinearLayout)findViewById(n.d.root);
    paramContext.setOnClickListener(null);
    paramContext.addView(this.kEU, -1, 0);
  }
  
  public final boolean aWH()
  {
    return this.kEU.getVisibility() == 0;
  }
  
  public final void aWI()
  {
    this.kEU.TG();
    if (this.kEU.getVisibility() == 0) {
      this.kEU.setVisibility(8);
    }
    setVisibility(8);
  }
  
  public final void aWJ()
  {
    this.kEU.TG();
    if (this.kEU.getVisibility() == 0) {
      this.kEU.setVisibility(4);
    }
  }
  
  public final void aWK()
  {
    this.kEU.setVisibility(0);
  }
  
  protected List<View> getPanelView()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.kEU);
    return localArrayList;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    if (m >= 0)
    {
      if (this.kET >= 0) {
        break label36;
      }
      this.kET = m;
    }
    label36:
    int n;
    label76:
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    do
    {
      do
      {
        do
        {
          super.onMeasure(paramInt1, paramInt2);
          return;
          n = this.kET - m;
          this.kET = m;
        } while (n == 0);
        localObject = getPanelView();
      } while (localObject == null);
      Object localObject = ((List)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localView = (View)((Iterator)localObject).next();
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    } while (localLayoutParams == null);
    if (localLayoutParams.height < 0) {}
    for (int i = 0;; i = localLayoutParams.height - n)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      int i1 = a.fromDPToPix(getContext(), 172);
      i = a.fromDPToPix(getContext(), 172);
      int k = j;
      if (j.zM() > 0)
      {
        k = j;
        if (m >= j.zM()) {
          k = i;
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k < i1)
        {
          j = k;
          if (localView.getVisibility() != 0) {
            j = 0;
          }
        }
      }
      k = j;
      if (j > i) {
        k = i;
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k < i) {
          j = i;
        }
      }
      localLayoutParams.height = j;
      localView.setLayoutParams(localLayoutParams);
      break label76;
      break;
    }
  }
  
  public void setEditText(FTSSayFooter.a parama)
  {
    this.kEV = parama;
  }
  
  public void setVoiceStateListener(b paramb)
  {
    this.kEX = paramb;
  }
  
  public static abstract interface b
  {
    public abstract void dl(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSSayFooter
 * JD-Core Version:    0.7.0.1
 */