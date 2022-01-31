package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KActionSheet;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;
import java.util.ArrayList;
import java.util.List;

public class KindaActionSheetImpl
  implements KActionSheet
{
  private List<VoidCallback> buttonCallbacks;
  private List<String> buttonTitles;
  private d sheet;
  private String title;
  
  public KindaActionSheetImpl()
  {
    AppMethodBeat.i(144712);
    this.buttonTitles = new ArrayList();
    this.buttonCallbacks = new ArrayList();
    AppMethodBeat.o(144712);
  }
  
  public void addButtonImpl(String paramString, VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(144713);
    this.buttonTitles.add(paramString);
    this.buttonCallbacks.add(paramVoidCallback);
    AppMethodBeat.o(144713);
  }
  
  public void setCancelButtonTitle(String paramString) {}
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void show()
  {
    AppMethodBeat.i(144714);
    Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
    if (localActivity != null) {
      if (this.title == null) {
        break label79;
      }
    }
    label79:
    for (boolean bool = true;; bool = false)
    {
      this.sheet = new d(localActivity, 1, bool);
      this.sheet.sao = new KindaActionSheetImpl.1(this);
      this.sheet.sap = new KindaActionSheetImpl.2(this);
      this.sheet.crd();
      AppMethodBeat.o(144714);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaActionSheetImpl
 * JD-Core Version:    0.7.0.1
 */