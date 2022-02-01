package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.kinda.framework.R.id;
import com.tencent.kinda.framework.R.layout;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KActionSheet;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KindaActionSheetImpl
  implements KActionSheet
{
  private List<VoidCallback> buttonCallbacks;
  private List<String> buttonTitles;
  private int mDestructiveIndex;
  private f sheet;
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
        break label142;
      }
    }
    label142:
    for (boolean bool = true;; bool = false)
    {
      this.sheet = new f(localActivity, 1, bool);
      if (bool)
      {
        View localView = af.mU(localActivity).inflate(R.layout.mm_bottom_sheet_title_text, null);
        TextView localTextView = (TextView)localView.findViewById(R.id.title_text);
        localTextView.setText(this.title);
        localTextView.setTextSize(14.0F);
        localTextView.setGravity(17);
        this.sheet.af(localView, false);
      }
      this.sheet.Vtg = new u.g()
      {
        public void onCreateMMMenu(s paramAnonymouss)
        {
          AppMethodBeat.i(18830);
          Iterator localIterator = KindaActionSheetImpl.this.buttonTitles.iterator();
          int i = 0;
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((KindaActionSheetImpl.this.mDestructiveIndex >= 0) && (KindaActionSheetImpl.this.mDestructiveIndex == i)) {
              paramAnonymouss.a(i, localActivity.getResources().getColor(a.c.Red), str);
            }
            for (;;)
            {
              i += 1;
              break;
              paramAnonymouss.add(0, i, 0, str);
            }
          }
          AppMethodBeat.o(18830);
        }
      };
      this.sheet.GAC = new u.i()
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
      this.sheet.dDn();
      AppMethodBeat.o(18834);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaActionSheetImpl
 * JD-Core Version:    0.7.0.1
 */