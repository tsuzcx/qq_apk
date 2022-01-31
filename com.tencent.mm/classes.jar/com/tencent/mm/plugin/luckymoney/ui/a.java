package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private List<b> lVF = new LinkedList();
  private boolean lVG = false;
  private boolean lVH = false;
  private TextView lVI;
  
  public final void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.lVF.add(paramb);
  }
  
  public final boolean bgi()
  {
    this.lVH = false;
    this.lVG = false;
    int i = 0;
    if (i < this.lVF.size())
    {
      Object localObject = (b)this.lVF.get(i);
      int j = ((b)localObject).bfp();
      if (j != 0)
      {
        ((b)localObject).onError();
        localObject = ((b)localObject).td(j);
        if ((this.lVI != null) && (!bk.bl((String)localObject)))
        {
          if (!this.lVG) {
            this.lVI.setText((CharSequence)localObject);
          }
          this.lVI.setVisibility(0);
          this.lVG = true;
        }
        this.lVH = true;
      }
      for (;;)
      {
        i += 1;
        break;
        ((b)localObject).restore();
      }
    }
    if ((!this.lVH) && (this.lVI != null))
    {
      this.lVI.setVisibility(8);
      this.lVG = false;
    }
    return this.lVH;
  }
  
  public final boolean bgj()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.lVF.size())
      {
        if (((b)this.lVF.get(i)).bfp() != 0) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final void clear()
  {
    this.lVF.clear();
    this.lVI = null;
  }
  
  public final void g(TextView paramTextView)
  {
    if (paramTextView != null) {
      this.lVI = paramTextView;
    }
  }
  
  public final void tR(String paramString)
  {
    if ((this.lVI != null) && (!bk.bl(paramString)))
    {
      this.lVI.setText(paramString);
      this.lVI.setVisibility(0);
      this.lVG = true;
    }
    while (this.lVI == null) {
      return;
    }
    this.lVI.setVisibility(8);
    this.lVG = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.a
 * JD-Core Version:    0.7.0.1
 */