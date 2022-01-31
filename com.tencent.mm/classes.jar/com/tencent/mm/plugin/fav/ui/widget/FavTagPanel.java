package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;
import java.util.LinkedList;

public class FavTagPanel
  extends MMTagPanel
{
  private LinkedList<MMTagPanel.d> mEp;
  private FavTagPanel.a mEq;
  private View.OnClickListener mEr;
  
  public FavTagPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(74709);
    this.mEp = new LinkedList();
    this.mEq = null;
    this.mEr = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(74707);
        if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
        {
          FavTagPanel.a(FavTagPanel.this, (TextView)paramAnonymousView);
          if (FavTagPanel.a(FavTagPanel.this) != null)
          {
            paramAnonymousView.post(new FavTagPanel.1.1(this, paramAnonymousView));
            AppMethodBeat.o(74707);
          }
        }
        else
        {
          FavTagPanel.b(FavTagPanel.this, (TextView)paramAnonymousView);
          if (FavTagPanel.a(FavTagPanel.this) != null) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(74706);
                FavTagPanel.a(FavTagPanel.this).Og(((TextView)paramAnonymousView).getText().toString());
                AppMethodBeat.o(74706);
              }
            });
          }
        }
        AppMethodBeat.o(74707);
      }
    };
    AppMethodBeat.o(74709);
  }
  
  public FavTagPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(74708);
    this.mEp = new LinkedList();
    this.mEq = null;
    this.mEr = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(74707);
        if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
        {
          FavTagPanel.a(FavTagPanel.this, (TextView)paramAnonymousView);
          if (FavTagPanel.a(FavTagPanel.this) != null)
          {
            paramAnonymousView.post(new FavTagPanel.1.1(this, paramAnonymousView));
            AppMethodBeat.o(74707);
          }
        }
        else
        {
          FavTagPanel.b(FavTagPanel.this, (TextView)paramAnonymousView);
          if (FavTagPanel.a(FavTagPanel.this) != null) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(74706);
                FavTagPanel.a(FavTagPanel.this).Og(((TextView)paramAnonymousView).getText().toString());
                AppMethodBeat.o(74706);
              }
            });
          }
        }
        AppMethodBeat.o(74707);
      }
    };
    AppMethodBeat.o(74708);
  }
  
  public final void byt() {}
  
  public void setCallBack(FavTagPanel.a parama)
  {
    AppMethodBeat.i(74710);
    this.mEq = parama;
    super.setCallBack(parama);
    AppMethodBeat.o(74710);
  }
  
  public void setType(String paramString)
  {
    AppMethodBeat.i(74711);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.FavTagPanel", "want to add type, but it is null or empty");
      AppMethodBeat.o(74711);
      return;
    }
    paramString = paramString.trim();
    Object localObject = this.mEp.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((MMTagPanel.d)((Iterator)localObject).next()).zmO))
      {
        ab.w("MicroMsg.FavTagPanel", "want to add type %s, but it exsited!", new Object[] { paramString });
        AppMethodBeat.o(74711);
        return;
      }
    }
    this.mEp.clear();
    localObject = dEp();
    this.mEp.add(localObject);
    a((MMTagPanel.d)localObject, paramString, true);
    ((MMTagPanel.d)localObject).zmP.setOnClickListener(this.mEr);
    removeViews(0, getChildCount() - 1);
    addView(((MMTagPanel.d)localObject).zmP, 0);
    dEq();
    AppMethodBeat.o(74711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavTagPanel
 * JD-Core Version:    0.7.0.1
 */