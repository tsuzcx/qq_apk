package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;
import java.util.LinkedList;

public class FavTagPanel
  extends MMTagPanel
{
  private LinkedList<MMTagPanel.d> ApQ;
  private a ApR;
  private View.OnClickListener ApS;
  
  public FavTagPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107556);
    this.ApQ = new LinkedList();
    this.ApR = null;
    this.ApS = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(107554);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/fav/ui/widget/FavTagPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
                FavTagPanel.a(FavTagPanel.this).auI(((TextView)paramAnonymousView).getText().toString());
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
    this.ApQ = new LinkedList();
    this.ApR = null;
    this.ApS = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(107554);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/fav/ui/widget/FavTagPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
                FavTagPanel.a(FavTagPanel.this).auI(((TextView)paramAnonymousView).getText().toString());
                AppMethodBeat.o(107553);
              }
            });
          }
        }
      }
    };
    AppMethodBeat.o(107555);
  }
  
  public final boolean dSR()
  {
    return true;
  }
  
  public final void dSS() {}
  
  public void setCallBack(a parama)
  {
    AppMethodBeat.i(107557);
    this.ApR = parama;
    super.setCallBack(parama);
    AppMethodBeat.o(107557);
  }
  
  public void setType(String paramString)
  {
    AppMethodBeat.i(107558);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.FavTagPanel", "want to add type, but it is null or empty");
      AppMethodBeat.o(107558);
      return;
    }
    paramString = paramString.trim();
    Object localObject = this.ApQ.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((MMTagPanel.d)((Iterator)localObject).next()).adUf))
      {
        Log.w("MicroMsg.FavTagPanel", "want to add type %s, but it exsited!", new Object[] { paramString });
        AppMethodBeat.o(107558);
        return;
      }
    }
    this.ApQ.clear();
    localObject = jmJ();
    this.ApQ.add(localObject);
    a((MMTagPanel.d)localObject, paramString, true);
    ((MMTagPanel.d)localObject).adUg.setOnClickListener(this.ApS);
    removeViews(0, getChildCount() - 1);
    addView(((MMTagPanel.d)localObject).adUg, 0);
    jmK();
    AppMethodBeat.o(107558);
  }
  
  public static abstract interface a
    extends MMTagPanel.a
  {
    public abstract void auI(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavTagPanel
 * JD-Core Version:    0.7.0.1
 */