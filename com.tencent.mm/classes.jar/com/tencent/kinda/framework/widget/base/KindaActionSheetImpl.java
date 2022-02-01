package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KActionSheet;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KindaActionSheetImpl
  implements KActionSheet
{
  private List<VoidCallback> buttonCallbacks;
  private List<String> buttonTitles;
  private int mDestructiveIndex;
  private e sheet;
  private String title;
  
  public KindaActionSheetImpl()
  {
    AppMethodBeat.i(18832);
    this.mDestructiveIndex = -1;
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
  
  public void setDestructiveIndex(int paramInt)
  {
    this.mDestructiveIndex = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void show()
  {
    AppMethodBeat.i(18834);
    final Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
    if (localActivity != null) {
      if (this.title == null) {
        break label140;
      }
    }
    label140:
    for (boolean bool = true;; bool = false)
    {
      this.sheet = new e(localActivity, 1, bool);
      if (bool)
      {
        View localView = z.jV(localActivity).inflate(2131494775, null);
        TextView localTextView = (TextView)localView.findViewById(2131305945);
        localTextView.setText(this.title);
        localTextView.setTextSize(14.0F);
        localTextView.setGravity(17);
        this.sheet.P(localView, false);
      }
      this.sheet.LfS = new n.d()
      {
        public void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(18830);
          Iterator localIterator = KindaActionSheetImpl.this.buttonTitles.iterator();
          int i = 0;
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((KindaActionSheetImpl.this.mDestructiveIndex >= 0) && (KindaActionSheetImpl.this.mDestructiveIndex == i)) {
              paramAnonymousl.a(i, localActivity.getResources().getColor(2131099803), str);
            }
            for (;;)
            {
              i += 1;
              break;
              paramAnonymousl.add(0, i, 0, str);
            }
          }
          AppMethodBeat.o(18830);
        }
      };
      this.sheet.LfT = new n.e()
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
      this.sheet.cPF();
      AppMethodBeat.o(18834);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaActionSheetImpl
 * JD-Core Version:    0.7.0.1
 */