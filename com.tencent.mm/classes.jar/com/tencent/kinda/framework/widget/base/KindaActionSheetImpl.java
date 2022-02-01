package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import android.view.MenuItem;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KActionSheet;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KindaActionSheetImpl
  implements KActionSheet
{
  private List<VoidCallback> buttonCallbacks;
  private List<String> buttonTitles;
  private e sheet;
  private String title;
  
  public KindaActionSheetImpl()
  {
    AppMethodBeat.i(18832);
    this.buttonTitles = new ArrayList();
    this.buttonCallbacks = new ArrayList();
    AppMethodBeat.o(18832);
  }
  
  public void addButtonImpl(String paramString, VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(18833);
    this.buttonTitles.add(paramString);
    this.buttonCallbacks.add(paramVoidCallback);
    AppMethodBeat.o(18833);
  }
  
  public void setCancelButtonTitle(String paramString) {}
  
  public void setDestructiveIndex(int paramInt) {}
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void show()
  {
    AppMethodBeat.i(18834);
    Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
    if (localActivity != null) {
      if (this.title == null) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      this.sheet = new e(localActivity, 1, bool);
      this.sheet.HrX = new n.c()
      {
        public void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(18830);
          Iterator localIterator = KindaActionSheetImpl.this.buttonTitles.iterator();
          int i = 0;
          while (localIterator.hasNext())
          {
            paramAnonymousl.add(0, i, 0, (String)localIterator.next());
            i += 1;
          }
          AppMethodBeat.o(18830);
        }
      };
      this.sheet.HrY = new n.d()
      {
        public void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(18831);
          if (paramAnonymousInt < KindaActionSheetImpl.this.buttonCallbacks.size()) {
            ((VoidCallback)KindaActionSheetImpl.this.buttonCallbacks.get(paramAnonymousInt)).call();
          }
          AppMethodBeat.o(18831);
        }
      };
      this.sheet.csG();
      AppMethodBeat.o(18834);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaActionSheetImpl
 * JD-Core Version:    0.7.0.1
 */