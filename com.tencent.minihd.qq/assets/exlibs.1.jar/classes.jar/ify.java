import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.BigEmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.HorizonEmoticonTabs;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ify
  extends EmoticonPackageDownloadListener
{
  public ify(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void onCoverComplete(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onCoverComplete");
    }
    if ((paramEmoticonPackage == null) || (this.a.c == null)) {
      break label28;
    }
    label28:
    label284:
    for (;;)
    {
      return;
      if ((paramInt2 == 0) && (EmoticonMainPanel.g == 2))
      {
        label60:
        Object localObject;
        if (paramInt1 == 4)
        {
          paramInt2 = this.a.c.size();
          paramInt1 = 0;
          if (paramInt1 >= paramInt2) {
            break label279;
          }
          localObject = (EmoticonViewBinder)this.a.c.get(paramInt1);
          if ((localObject != null) && ((localObject instanceof BigEmoticonViewBinder)))
          {
            localObject = (BigEmoticonViewBinder)localObject;
            if ((((BigEmoticonViewBinder)localObject).a != null) && (((BigEmoticonViewBinder)localObject).a.epId.equals(paramEmoticonPackage.epId))) {
              paramEmoticonPackage = ((BigEmoticonViewBinder)localObject).a(this.a.getContext());
            }
          }
        }
        for (;;)
        {
          if ((EmoticonMainPanel.a(this.a) == null) || (paramInt1 == -1)) {
            break label284;
          }
          EmoticonMainPanel.a(this.a).a(paramEmoticonPackage, paramInt1);
          return;
          paramInt1 += 1;
          break label60;
          if (paramInt1 != 2) {
            break;
          }
          paramInt2 = this.a.c.size();
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            localObject = (EmoticonViewBinder)this.a.c.get(paramInt1);
            if ((localObject != null) && ((localObject instanceof BigEmoticonViewBinder)))
            {
              localObject = (BigEmoticonViewBinder)localObject;
              if ((((BigEmoticonViewBinder)localObject).a != null) && (((BigEmoticonViewBinder)localObject).a.epId.equals(paramEmoticonPackage.epId)))
              {
                ((BigEmoticonViewBinder)localObject).c();
                return;
              }
            }
            paramInt1 += 1;
          }
          break label28;
          paramEmoticonPackage = null;
          paramInt1 = -1;
        }
      }
    }
  }
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    this.a.post(new ifz(this, paramEmoticonPackage, paramInt));
  }
  
  public void onPackageProgress(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "onPackageProgress: epId=" + paramEmoticonPackage.epId);
          }
        } while ((EmoticonMainPanel.g != 2) || (this.a.c == null) || (EmoticonMainPanel.i >= this.a.c.size()));
        localObject = (EmoticonViewBinder)this.a.c.get(EmoticonMainPanel.i);
      } while ((localObject == null) || (!(localObject instanceof BigEmoticonViewBinder)));
      localObject = (BigEmoticonViewBinder)localObject;
    } while ((((BigEmoticonViewBinder)localObject).a == null) || (!((BigEmoticonViewBinder)localObject).a.epId.equals(paramEmoticonPackage.epId)));
    ((BigEmoticonViewBinder)localObject).b(paramEmoticonPackage);
  }
  
  public void onPackageStart(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "onPackageStart: epId=" + paramEmoticonPackage.epId);
          }
        } while ((EmoticonMainPanel.g != 2) || (this.a.c == null) || (EmoticonMainPanel.i >= this.a.c.size()));
        localObject = (EmoticonViewBinder)this.a.c.get(EmoticonMainPanel.i);
      } while ((localObject == null) || (!(localObject instanceof BigEmoticonViewBinder)));
      localObject = (BigEmoticonViewBinder)localObject;
    } while ((((BigEmoticonViewBinder)localObject).a == null) || (!((BigEmoticonViewBinder)localObject).a.epId.equals(paramEmoticonPackage.epId)));
    ((BigEmoticonViewBinder)localObject).b(paramEmoticonPackage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ify
 * JD-Core Version:    0.7.0.1
 */