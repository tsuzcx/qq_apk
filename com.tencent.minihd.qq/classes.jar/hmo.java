import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class hmo
  implements Comparator
{
  hmo(hmm paramhmm) {}
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    int j = paramPhoneContact1.sortWeight - paramPhoneContact2.sortWeight;
    int i = j;
    if (j == 0)
    {
      Object localObject2 = paramPhoneContact1.pinyinFirst;
      String str = paramPhoneContact2.pinyinFirst;
      Object localObject1 = localObject2;
      if (((String)localObject2).endsWith("#")) {
        localObject1 = "Za";
      }
      localObject2 = str;
      if (str.endsWith("#")) {
        localObject2 = "Za";
      }
      j = ((String)localObject1).compareTo((String)localObject2);
      i = j;
      if (j == 0) {
        i = paramPhoneContact1.pinyinAll.compareTo(paramPhoneContact2.pinyinAll);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hmo
 * JD-Core Version:    0.7.0.1
 */