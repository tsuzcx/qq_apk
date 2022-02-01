package com.tencent.mm.plugin.groupsolitaire.ui;

import android.support.design.widget.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.picker.CustomDatePicker;
import java.util.Calendar;
import java.util.Locale;

final class GroupSolitatireEditUI$24
  implements View.OnClickListener
{
  GroupSolitatireEditUI$24(GroupSolitatireEditUI paramGroupSolitatireEditUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110455);
    GroupSolitatireEditUI.a(this.srR);
    if (((GroupSolitatireEditUI.b(this.srR) instanceof MMEditText)) && ((GroupSolitatireEditUI.b(this.srR).getParent() instanceof RelativeLayout))) {
      ((RelativeLayout)GroupSolitatireEditUI.b(this.srR).getParent()).setTag(Integer.valueOf(1));
    }
    paramView = new b(this.srR);
    int i;
    int j;
    label103:
    int k;
    if (paramView.srm != null)
    {
      i = paramView.srm.getYear();
      if (paramView.srm == null) {
        break label267;
      }
      j = paramView.srm.getMonth();
      if (paramView.srm == null) {
        break label272;
      }
      k = paramView.srm.getDayOfMonth();
      label119:
      paramView.srn = new GroupSolitatireEditUI.24.1(this);
      if ((i >= 0) && (j >= 0) && (k >= 0)) {
        break label278;
      }
    }
    for (;;)
    {
      Calendar localCalendar = Calendar.getInstance(Locale.US);
      localCalendar.set(2009, 0, 1);
      if (paramView.srm != null) {
        paramView.srm.setMinDate(localCalendar.getTimeInMillis());
      }
      localCalendar = Calendar.getInstance(Locale.US);
      localCalendar.set(2029, 11, 31);
      if (paramView.srm != null) {
        paramView.srm.setMaxDate(localCalendar.getTimeInMillis());
      }
      if (paramView.sri != null)
      {
        if (paramView.srm != null) {
          paramView.srm.bui();
        }
        paramView.sri.show();
      }
      this.srR.EQ(0);
      AppMethodBeat.o(110455);
      return;
      i = 0;
      break;
      label267:
      j = 0;
      break label103;
      label272:
      k = 0;
      break label119;
      label278:
      if (paramView.srm != null) {
        paramView.srm.a(i, j, k, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.24
 * JD-Core Version:    0.7.0.1
 */