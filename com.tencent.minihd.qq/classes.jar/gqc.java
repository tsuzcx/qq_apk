import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.search.ContactsSearchablePhoneContact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class gqc
  extends SearchResultDialog
{
  public gqc(ContactListView paramContactListView, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, ForwardOperations paramForwardOperations, int paramInt2)
  {
    super(paramContext, paramQQAppInterface, paramInt1, paramForwardOperations, paramInt2);
  }
  
  @SuppressLint({"UseSparseArrays"})
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((this.a.jdField_a_of_type_Int == 0) || (this.a.jdField_a_of_type_Int == 2) || (this.a.jdField_a_of_type_Int == 4))
    {
      if (this.a.jdField_a_of_type_JavaUtilList != null) {
        localObject2 = this.a.jdField_a_of_type_JavaUtilList.iterator();
      }
    }
    else {
      while (((Iterator)localObject2).hasNext())
      {
        ((ArrayList)localObject1).addAll((List)((Iterator)localObject2).next());
        continue;
        if ((this.a.jdField_a_of_type_Int == 3) && (this.a.b != null)) {
          ((ArrayList)localObject1).addAll(this.a.b);
        }
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PhoneContact)((Iterator)localObject1).next();
      if (!TextUtils.isEmpty(((PhoneContact)localObject2).uin)) {}
      for (long l = 34359738368L;; l = 8589934592L)
      {
        localArrayList.add(new ContactsSearchablePhoneContact(paramContext, paramQQAppInterface, (PhoneContact)localObject2, l));
        break;
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gqc
 * JD-Core Version:    0.7.0.1
 */