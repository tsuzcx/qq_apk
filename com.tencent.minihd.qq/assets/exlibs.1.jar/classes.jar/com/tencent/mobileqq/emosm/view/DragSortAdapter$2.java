package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.ProgressButton;

class DragSortAdapter$2
  implements View.OnClickListener
{
  DragSortAdapter$2(DragSortAdapter paramDragSortAdapter, EmoticonPackage paramEmoticonPackage, View paramView) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.this$0.mContext).getAppRuntime();
    if ((this.val$pkg.valid) && (this.val$pkg != null))
    {
      if (((Integer)paramView.getTag()).intValue() != 0) {
        break label189;
      }
      ((EmojiManager)localQQAppInterface.getManager(42)).a(this.val$pkg, true);
      if ((paramView instanceof ProgressButton))
      {
        paramView = (ProgressButton)paramView;
        paramView.setVisibility(0);
        paramView.setProgress(0);
        paramView.setTag(Integer.valueOf(1));
        paramView.setTextColor(DragSortAdapter.access$000(this.this$0));
        paramView.setText("取消");
      }
      ReportController.b(localQQAppInterface, "CliOper", "", localQQAppInterface.a(), "ep_mall", "Clk_updatepkg_mine", 0, 0, this.val$pkg.epId, "" + this.val$pkg.localVersion, "" + this.val$pkg.latestVersion, "");
    }
    label189:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (((Integer)paramView.getTag()).intValue() != 1) {
              break;
            }
            ((EmojiManager)localQQAppInterface.getManager(42)).a(this.val$pkg.epId);
          } while (!(paramView instanceof ProgressButton));
          paramView = (ProgressButton)paramView;
          paramView.setVisibility(0);
          paramView.setProgress(0);
          paramView.setTextColor(DragSortAdapter.access$000(this.this$0));
          paramView.setTag(Integer.valueOf(0));
          paramView.setText(2131368464);
          return;
          if (((Integer)paramView.getTag()).intValue() != 3) {
            break;
          }
          if (!NetworkUtil.b(this.this$0.mContext))
          {
            DialogUtil.a(this.this$0.mContext, 230).setTitle(this.this$0.mContext.getString(2131365995)).setMessage(this.this$0.mContext.getString(2131368602)).setPositiveButton(this.this$0.mContext.getString(2131366763), new DragSortAdapter.2.2(this, paramView)).setNegativeButton(this.this$0.mContext.getString(2131366764), new DragSortAdapter.2.1(this)).show();
            return;
          }
        } while (!NetworkUtil.b(this.this$0.mContext));
        DragSortAdapter.access$100(this.this$0, this.val$pkg, this.val$updateLayout, paramView);
        return;
      } while (((Integer)paramView.getTag()).intValue() != 2);
      ((EmojiManager)localQQAppInterface.getManager(42)).a(this.val$pkg.epId);
    } while (!(paramView instanceof ProgressButton));
    paramView = (ProgressButton)paramView;
    paramView.setVisibility(0);
    paramView.setProgress(0);
    paramView.setTag(Integer.valueOf(3));
    paramView.setTextColor(DragSortAdapter.access$000(this.this$0));
    paramView.setText(2131368465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter.2
 * JD-Core Version:    0.7.0.1
 */