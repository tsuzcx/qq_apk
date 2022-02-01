package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import java.util.ArrayList;
import java.util.List;

public class MassSendLayout
  extends BasePanelKeybordLayout
{
  private View qdl;
  
  public MassSendLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MassSendLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(26445);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.qdl);
    AppMethodBeat.o(26445);
    return localArrayList;
  }
  
  public void setPanel(View paramView)
  {
    this.qdl = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendLayout
 * JD-Core Version:    0.7.0.1
 */