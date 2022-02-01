package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import java.util.HashSet;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  BackupMoveChooseUI mVO;
  HashSet<Integer> mVP;
  
  public a(BackupMoveChooseUI paramBackupMoveChooseUI)
  {
    AppMethodBeat.i(21377);
    this.mVO = paramBackupMoveChooseUI;
    this.mVP = new HashSet();
    AppMethodBeat.o(21377);
  }
  
  private static f.b wQ(int paramInt)
  {
    AppMethodBeat.i(21379);
    f.b localb = (f.b)b.bDy().bDC().bDu().get(paramInt);
    AppMethodBeat.o(21379);
    return localb;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(21378);
    LinkedList localLinkedList = b.bDy().bDC().bDu();
    if (localLinkedList != null)
    {
      int i = localLinkedList.size();
      AppMethodBeat.o(21378);
      return i;
    }
    AppMethodBeat.o(21378);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(21380);
    f.b localb;
    if (paramView == null)
    {
      paramView = this.mVO.getLayoutInflater().inflate(2131493137, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.fuY = ((ImageView)paramView.findViewById(2131297008));
      paramViewGroup.iCg = ((TextView)paramView.findViewById(2131305948));
      paramViewGroup.iCi = ((CheckBox)paramView.findViewById(2131304502));
      paramViewGroup.mVR = ((RelativeLayout)paramView.findViewById(2131304503));
      paramView.setTag(paramViewGroup);
      paramViewGroup.mVR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21376);
          if (a.a(a.this).contains(Integer.valueOf(paramInt))) {
            a.a(a.this).remove(Integer.valueOf(paramInt));
          }
          for (;;)
          {
            a.this.notifyDataSetChanged();
            a.b(a.this).a(a.a(a.this));
            AppMethodBeat.o(21376);
            return;
            a.a(a.this).add(Integer.valueOf(paramInt));
          }
        }
      });
      localb = wQ(paramInt);
      a.b.c(paramViewGroup.fuY, localb.mSz);
      if (!w.sQ(localb.mSz)) {
        break label211;
      }
      paramViewGroup.iCg.setText(k.b(this.mVO, v.getDisplayName(localb.mSz, localb.mSz), paramViewGroup.iCg.getTextSize()));
      label170:
      if (!this.mVP.contains(Integer.valueOf(paramInt))) {
        break label243;
      }
      paramViewGroup.iCi.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(21380);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label211:
      paramViewGroup.iCg.setText(k.b(this.mVO, v.wk(localb.mSz), paramViewGroup.iCg.getTextSize()));
      break label170;
      label243:
      paramViewGroup.iCi.setChecked(false);
    }
  }
  
  final class a
  {
    ImageView fuY;
    TextView iCg;
    CheckBox iCi;
    RelativeLayout mVR;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.a
 * JD-Core Version:    0.7.0.1
 */