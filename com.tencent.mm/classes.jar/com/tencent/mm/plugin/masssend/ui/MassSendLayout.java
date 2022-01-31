package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import java.util.ArrayList;
import java.util.List;

public class MassSendLayout
  extends BasePanelKeybordLayout
{
  private View iwe;
  
  public MassSendLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MassSendLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected List<View> getPanelView()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.iwe);
    return localArrayList;
  }
  
  public void setPanel(View paramView)
  {
    this.iwe = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendLayout
 * JD-Core Version:    0.7.0.1
 */