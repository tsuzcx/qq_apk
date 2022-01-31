package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class e
  extends a
{
  private static a.b icr;
  int El;
  long icw;
  String icx;
  String idR;
  
  public e(long paramLong, int paramInt, String paramString)
  {
    super(2, null);
    this.icw = paramLong;
    this.icx = paramString;
    this.El = paramInt;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    this.idR = "";
  }
  
  public final a.b axw()
  {
    if (icr == null) {
      icr = new a.b()
      {
        public final void a(Context paramAnonymousContext, a.a paramAnonymousa, a paramAnonymousVarArgs)
        {
          if ((paramAnonymousContext == null) || (paramAnonymousa == null) || (paramAnonymousVarArgs == null))
          {
            y.e("MicroMsg.ReadMoreBtnDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            return;
          }
          if (!(paramAnonymousa instanceof e.a))
          {
            y.e("MicroMsg.ReadMoreBtnDataItem", "The ViewHolder is not a instance of MoreBtnViewHolder.");
            return;
          }
          if (!(paramAnonymousVarArgs instanceof e))
          {
            y.e("MicroMsg.ReadMoreBtnDataItem", "The DataItem is not a instance of MoreBtnDataItem.");
            return;
          }
          paramAnonymousContext = (e.a)paramAnonymousa;
          paramAnonymousa = (e)paramAnonymousVarArgs;
          paramAnonymousContext.gSy.setText(paramAnonymousa.idR);
        }
        
        public final void a(View paramAnonymousView, a.a paramAnonymousa)
        {
          if ((paramAnonymousView != null) && (paramAnonymousa != null) && ((paramAnonymousa instanceof e.a))) {
            ((e.a)paramAnonymousa).gSy = ((TextView)paramAnonymousView.findViewById(b.d.tipsTV));
          }
        }
        
        public final boolean a(Context paramAnonymousContext, a paramAnonymousa, Object... paramAnonymousVarArgs)
        {
          if ((paramAnonymousContext != null) && (paramAnonymousa != null))
          {
            int j = 0;
            int i = j;
            if (paramAnonymousVarArgs != null)
            {
              i = j;
              if (paramAnonymousVarArgs.length >= 2)
              {
                i = j;
                if ((paramAnonymousVarArgs[1] instanceof Integer)) {
                  i = ((Integer)paramAnonymousVarArgs[1]).intValue();
                }
              }
            }
            paramAnonymousa = (e)paramAnonymousa;
            paramAnonymousVarArgs = new Intent(paramAnonymousContext, BizSearchDetailPageUI.class);
            paramAnonymousVarArgs.putExtra("keyword", paramAnonymousa.icx);
            paramAnonymousVarArgs.putExtra("businessType", paramAnonymousa.icw);
            paramAnonymousVarArgs.putExtra("offset", paramAnonymousa.El);
            paramAnonymousVarArgs.putExtra("showEditText", true);
            paramAnonymousVarArgs.putExtra("fromScene", i);
            paramAnonymousContext.startActivity(paramAnonymousVarArgs);
          }
          return true;
        }
        
        public final View b(Context paramAnonymousContext, View paramAnonymousView)
        {
          View localView = paramAnonymousView;
          if (paramAnonymousView == null) {
            localView = View.inflate(paramAnonymousContext, b.e.search_result_item_more, null);
          }
          return localView;
        }
      };
    }
    return icr;
  }
  
  public final a.a axx()
  {
    return new e.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.e
 * JD-Core Version:    0.7.0.1
 */