import android.util.Pair;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionIconHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class hix
  extends Thread
{
  public boolean a;
  
  private hix(DiscussionIconHelper paramDiscussionIconHelper)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread start.");
    }
    int i;
    long l;
    String str1;
    label62:
    String str2;
    hiz localhiz;
    Object localObject7;
    int j;
    boolean bool1;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 0;
      l = System.currentTimeMillis();
      str1 = null;
      Object localObject1 = null;
      synchronized (DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper))
      {
        Iterator localIterator = DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).keySet().iterator();
        if (!localIterator.hasNext()) {
          break label546;
        }
        str2 = (String)localIterator.next();
        localhiz = (hiz)DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).get(str2);
        if ((localhiz != null) && (localhiz.jdField_b_of_type_Int >= 8)) {
          DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).a(false, true, str2);
        }
      }
      if ((localhiz == null) || (localhiz.jdField_a_of_type_JavaLangString == null) || (localhiz.jdField_a_of_type_Byte == 3)) {
        break label808;
      }
      if ((localhiz.jdField_a_of_type_Byte == 1) && (l - localhiz.jdField_a_of_type_Long >= DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper)))
      {
        localObject7 = str1;
        if (str1 == null) {
          localObject7 = new ArrayList();
        }
        j = localhiz.jdField_a_of_type_JavaUtilArrayList.size();
        localhiz.jdField_a_of_type_Byte = 2;
        if (j <= 0) {
          break label825;
        }
        bool2 = true;
        bool1 = bool2;
        if (localhiz.jdField_b_of_type_JavaLangString != null)
        {
          str1 = DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, localhiz.jdField_a_of_type_JavaUtilArrayList, str2, false);
          bool1 = bool2;
          if (localhiz.jdField_b_of_type_JavaLangString.equals(str1)) {
            bool1 = false;
          }
        }
        bool2 = bool1;
        if (bool1)
        {
          ((ArrayList)localObject7).add(Pair.create(str2, localhiz));
          DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).remove(str2);
        }
      }
    }
    label546:
    label808:
    label811:
    label814:
    label822:
    label825:
    for (boolean bool2 = bool1;; bool2 = false)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.qqhead.dih", 2, "CheckDisIcon expired: " + str2 + ", iconCount: " + j + ", faceCount:" + localhiz.jdField_a_of_type_Int + ", isTryCreate: " + bool2 + ", faceUinSet: " + localhiz.jdField_a_of_type_JavaLangString);
        break label814;
        if ((localhiz.jdField_a_of_type_Byte == 2) && (l - localhiz.jdField_a_of_type_Long >= DiscussionIconHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "CheckDisIcon timeout: " + str2 + ", iconCount: " + localhiz.jdField_a_of_type_JavaUtilArrayList.size() + ", faceCount:" + localhiz.jdField_a_of_type_Int + ", faceUinSet: " + localhiz.jdField_a_of_type_JavaLangString);
          }
          if (localObject2 != null) {
            break label811;
          }
          ??? = new ArrayList();
        }
        for (;;)
        {
          for (;;)
          {
            ((ArrayList)???).add(str2);
            i += 1;
            break label822;
            if (localhiz.jdField_a_of_type_Byte == 3) {
              break label808;
            }
            i += 1;
            break label822;
            if ((this.jdField_a_of_type_Boolean) && (str1 != null))
            {
              j = 0;
              while ((j < str1.size()) && (this.jdField_a_of_type_Boolean))
              {
                localObject7 = (Pair)str1.get(j);
                DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, (String)((Pair)localObject7).first, (hiz)((Pair)localObject7).second, true);
                j += 1;
              }
            }
            if ((this.jdField_a_of_type_Boolean) && (??? != null))
            {
              j = 0;
              while ((j < ((ArrayList)???).size()) && (this.jdField_a_of_type_Boolean))
              {
                str1 = (String)((ArrayList)???).get(j);
                this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper.c(str1);
                j += 1;
              }
            }
            if (i == 0) {}
            synchronized (DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper))
            {
              DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper, null);
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread exit. isRunning=" + this.jdField_a_of_type_Boolean);
              }
              return;
              if (!this.jdField_a_of_type_Boolean) {
                break;
              }
            }
          }
          try
          {
            synchronized (DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper))
            {
              DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper).wait(DiscussionIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionIconHelper) / 10);
            }
            localObject5 = finally;
            throw localObject5;
          }
          catch (InterruptedException localInterruptedException)
          {
            break label781;
          }
          break label822;
        }
      }
      Object localObject6 = localObject7;
      i += 1;
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hix
 * JD-Core Version:    0.7.0.1
 */