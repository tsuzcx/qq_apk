package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;
import java.util.LinkedList;

public class FavTagPanel
  extends MMTagPanel
{
  private LinkedList<MMTagPanel.d> kjK = new LinkedList();
  private FavTagPanel.a kjL = null;
  private View.OnClickListener kjM = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
      {
        FavTagPanel.a(FavTagPanel.this, (TextView)paramAnonymousView);
        if (FavTagPanel.a(FavTagPanel.this) != null) {
          paramAnonymousView.post(new FavTagPanel.1.1(this, paramAnonymousView));
        }
      }
      do
      {
        return;
        FavTagPanel.b(FavTagPanel.this, (TextView)paramAnonymousView);
      } while (FavTagPanel.a(FavTagPanel.this) == null);
      paramAnonymousView.post(new FavTagPanel.1.2(this, paramAnonymousView));
    }
  };
  
  public FavTagPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FavTagPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static void aSd() {}
  
  protected final void aSc() {}
  
  public void setCallBack(FavTagPanel.a parama)
  {
    this.kjL = parama;
    super.setCallBack(parama);
  }
  
  public void setType(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.FavTagPanel", "want to add type, but it is null or empty");
      return;
    }
    paramString = paramString.trim();
    Object localObject = this.kjK.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((MMTagPanel.d)((Iterator)localObject).next()).uYy))
      {
        y.w("MicroMsg.FavTagPanel", "want to add type %s, but it exsited!", new Object[] { paramString });
        return;
      }
    }
    this.kjK.clear();
    localObject = cBc();
    this.kjK.add(localObject);
    a((MMTagPanel.d)localObject, paramString, true);
    ((MMTagPanel.d)localObject).uYz.setOnClickListener(this.kjM);
    removeViews(0, getChildCount() - 1);
    addView(((MMTagPanel.d)localObject).uYz, 0);
    cBd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavTagPanel
 * JD-Core Version:    0.7.0.1
 */