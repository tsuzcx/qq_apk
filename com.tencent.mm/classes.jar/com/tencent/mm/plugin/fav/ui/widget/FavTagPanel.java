package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;
import java.util.LinkedList;

public class FavTagPanel
  extends MMTagPanel
{
  private LinkedList<MMTagPanel.d> rET;
  private FavTagPanel.a rEU;
  private View.OnClickListener rEV;
  
  public FavTagPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107556);
    this.rET = new LinkedList();
    this.rEU = null;
    this.rEV = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(107554);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/fav/ui/widget/FavTagPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
        {
          FavTagPanel.a(FavTagPanel.this, (TextView)paramAnonymousView);
          if (FavTagPanel.a(FavTagPanel.this) != null) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(107552);
                FavTagPanel.a(FavTagPanel.this);
                ((TextView)paramAnonymousView).getText().toString();
                AppMethodBeat.o(107552);
              }
            });
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavTagPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107554);
          return;
          FavTagPanel.b(FavTagPanel.this, (TextView)paramAnonymousView);
          if (FavTagPanel.a(FavTagPanel.this) != null) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(107553);
                FavTagPanel.a(FavTagPanel.this).agS(((TextView)paramAnonymousView).getText().toString());
                AppMethodBeat.o(107553);
              }
            });
          }
        }
      }
    };
    AppMethodBeat.o(107556);
  }
  
  public FavTagPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107555);
    this.rET = new LinkedList();
    this.rEU = null;
    this.rEV = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(107554);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/fav/ui/widget/FavTagPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
        {
          FavTagPanel.a(FavTagPanel.this, (TextView)paramAnonymousView);
          if (FavTagPanel.a(FavTagPanel.this) != null) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(107552);
                FavTagPanel.a(FavTagPanel.this);
                ((TextView)paramAnonymousView).getText().toString();
                AppMethodBeat.o(107552);
              }
            });
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavTagPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107554);
          return;
          FavTagPanel.b(FavTagPanel.this, (TextView)paramAnonymousView);
          if (FavTagPanel.a(FavTagPanel.this) != null) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(107553);
                FavTagPanel.a(FavTagPanel.this).agS(((TextView)paramAnonymousView).getText().toString());
                AppMethodBeat.o(107553);
              }
            });
          }
        }
      }
    };
    AppMethodBeat.o(107555);
  }
  
  public final void cxp() {}
  
  public void setCallBack(FavTagPanel.a parama)
  {
    AppMethodBeat.i(107557);
    this.rEU = parama;
    super.setCallBack(parama);
    AppMethodBeat.o(107557);
  }
  
  public void setType(String paramString)
  {
    AppMethodBeat.i(107558);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.FavTagPanel", "want to add type, but it is null or empty");
      AppMethodBeat.o(107558);
      return;
    }
    paramString = paramString.trim();
    Object localObject = this.rET.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((MMTagPanel.d)((Iterator)localObject).next()).JnW))
      {
        ad.w("MicroMsg.FavTagPanel", "want to add type %s, but it exsited!", new Object[] { paramString });
        AppMethodBeat.o(107558);
        return;
      }
    }
    this.rET.clear();
    localObject = fzc();
    this.rET.add(localObject);
    a((MMTagPanel.d)localObject, paramString, true);
    ((MMTagPanel.d)localObject).JnX.setOnClickListener(this.rEV);
    removeViews(0, getChildCount() - 1);
    addView(((MMTagPanel.d)localObject).JnX, 0);
    fzd();
    AppMethodBeat.o(107558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavTagPanel
 * JD-Core Version:    0.7.0.1
 */