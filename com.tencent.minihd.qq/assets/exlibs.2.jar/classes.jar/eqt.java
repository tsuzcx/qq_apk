import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vas.ColorRingPlayer;

public class eqt
  extends Handler
{
  public eqt(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = 1;
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      label116:
      label121:
      do
      {
        do
        {
          Object localObject1;
          Object localObject2;
          do
          {
            do
            {
              do
              {
                return;
                j = paramMessage.arg1;
                boolean bool;
                if ((j & 0x1) == 0)
                {
                  bool = true;
                  this.a.a(bool);
                  if ((j & 0x2) != 0) {
                    break label116;
                  }
                }
                for (;;)
                {
                  if (i == 0) {
                    break label121;
                  }
                  QQBrowserActivity.a(this.a).setVisibility(0);
                  return;
                  bool = false;
                  break;
                  i = 0;
                }
                QQBrowserActivity.b(this.a).setVisibility(8);
                return;
              } while (this.a.k);
              i = paramMessage.arg1;
              int j = paramMessage.arg2;
              paramMessage = QQBrowserActivity.a(this.a).getBackground();
              if (paramMessage != null)
              {
                localObject1 = paramMessage.getBounds();
                if ((((Rect)localObject1).width() <= 0) || ((((Rect)localObject1).height() <= 0) && (j < 20)))
                {
                  sendMessageDelayed(obtainMessage(2, i, j + 1), 50L);
                  return;
                }
              }
              localObject1 = QQBrowserActivity.c(this.a).getDrawable();
              if (localObject1 != null)
              {
                localObject2 = ((Drawable)localObject1).getBounds();
                if ((((Rect)localObject2).width() <= 0) || ((((Rect)localObject2).height() <= 0) && (j < 20)))
                {
                  sendMessageDelayed(obtainMessage(2, i, j + 1), 50L);
                  return;
                }
              }
              if (paramMessage != null)
              {
                if (!QQBrowserActivity.a(this.a))
                {
                  QQBrowserActivity.a(this.a, paramMessage);
                  QQBrowserActivity.a(this.a, true);
                }
                paramMessage = ImageUtil.a(paramMessage, i);
                if (paramMessage != null) {
                  QQBrowserActivity.b(this.a).setBackgroundDrawable(paramMessage);
                }
              }
            } while (localObject1 == null);
            if (!QQBrowserActivity.b(this.a))
            {
              QQBrowserActivity.b(this.a, (Drawable)localObject1);
              QQBrowserActivity.b(this.a, true);
            }
            paramMessage = ImageUtil.a((Drawable)localObject1, i);
          } while (paramMessage == null);
          QQBrowserActivity.d(this.a).setImageDrawable(paramMessage);
          return;
          if (QQBrowserActivity.a(this.a) == null)
          {
            localObject1 = (RelativeLayout)this.a.findViewById(2131296993);
            QQBrowserActivity.a(this.a, (ViewGroup)LayoutInflater.from(this.a).inflate(2130904081, null));
            localObject2 = new RelativeLayout.LayoutParams(-1, -2);
            ((RelativeLayout.LayoutParams)localObject2).addRule(12);
            ((RelativeLayout)localObject1).addView(QQBrowserActivity.a(this.a), (ViewGroup.LayoutParams)localObject2);
            QQBrowserActivity.a(this.a).setOnTouchListener(new equ(this));
          }
          if (QQBrowserActivity.a(this.a) == null) {
            QQBrowserActivity.a(this.a, new ColorRingPlayer(this.a, QQBrowserActivity.a(this.a)));
          }
          QQBrowserActivity.a(this.a).h();
          paramMessage = (Bundle)paramMessage.obj;
          QQBrowserActivity.a(this.a).a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getString("callbackId"));
          return;
          paramMessage = (Bundle)paramMessage.obj;
        } while (QQBrowserActivity.a(this.a) == null);
        QQBrowserActivity.a(this.a).a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getInt("status"), paramMessage.getString("callbackId"));
        return;
        paramMessage = (Bundle)paramMessage.obj;
      } while (QQBrowserActivity.a(this.a) == null);
      QQBrowserActivity.a(this.a).a(paramMessage.getString("callbackId"));
      return;
    }
    QQBrowserActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eqt
 * JD-Core Version:    0.7.0.1
 */