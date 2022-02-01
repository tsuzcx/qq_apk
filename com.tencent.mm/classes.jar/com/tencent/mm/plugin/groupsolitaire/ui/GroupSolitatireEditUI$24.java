package com.tencent.mm.plugin.groupsolitaire.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
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
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    GroupSolitatireEditUI.a(this.Jkd);
    if (((GroupSolitatireEditUI.b(this.Jkd) instanceof MMEditText)) && ((GroupSolitatireEditUI.b(this.Jkd).getParent() instanceof RelativeLayout))) {
      ((RelativeLayout)GroupSolitatireEditUI.b(this.Jkd).getParent()).setTag(Integer.valueOf(1));
    }
    paramView = new b(this.Jkd);
    int i;
    int j;
    label135:
    int k;
    if (paramView.Jjz != null)
    {
      i = paramView.Jjz.getYear();
      if (paramView.Jjz == null) {
        break label311;
      }
      j = paramView.Jjz.getMonth();
      if (paramView.Jjz == null) {
        break label316;
      }
      k = paramView.Jjz.getDayOfMonth();
      label151:
      paramView.JjA = new b.a()
      {
        public final void onResult(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(110454);
          if (paramAnonymousBoolean)
          {
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitaire time :%s", new Object[] { String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) }) });
            GroupSolitatireEditUI.a(GroupSolitatireEditUI.24.this.Jkd, String.format(Locale.US, "%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) }));
            GroupSolitatireEditUI.24.this.Jkd.Ye(1);
          }
          AppMethodBeat.o(110454);
        }
      };
      if ((i >= 0) && (j >= 0) && (k >= 0)) {
        break label322;
      }
    }
    for (;;)
    {
      localObject = Calendar.getInstance(Locale.US);
      ((Calendar)localObject).set(2009, 0, 1);
      if (paramView.Jjz != null) {
        paramView.Jjz.setMinDate(((Calendar)localObject).getTimeInMillis());
      }
      localObject = Calendar.getInstance(Locale.US);
      ((Calendar)localObject).set(2029, 11, 31);
      if (paramView.Jjz != null) {
        paramView.Jjz.setMaxDate(((Calendar)localObject).getTimeInMillis());
      }
      if (paramView.Jjv != null)
      {
        if (paramView.Jjz != null) {
          paramView.Jjz.cSm();
        }
        paramView.Jjv.show();
      }
      this.Jkd.Ye(0);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(110455);
      return;
      i = 0;
      break;
      label311:
      j = 0;
      break label135;
      label316:
      k = 0;
      break label151;
      label322:
      if (paramView.Jjz != null) {
        paramView.Jjz.a(i, j, k, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.24
 * JD-Core Version:    0.7.0.1
 */