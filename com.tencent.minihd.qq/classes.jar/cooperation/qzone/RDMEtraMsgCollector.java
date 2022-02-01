package cooperation.qzone;

import android.view.View;
import android.view.ViewGroup;

public class RDMEtraMsgCollector
{
  public static final int a = 5;
  private static RDMEtraMsgCollector a;
  public static final int b = 10;
  public static final int c = 10;
  public LoopQueue a;
  public LoopQueue b = new LoopQueue(10);
  public LoopQueue c = new LoopQueue(10);
  
  private RDMEtraMsgCollector()
  {
    this.jdField_a_of_type_CooperationQzoneLoopQueue = new LoopQueue(5);
  }
  
  public static RDMEtraMsgCollector a()
  {
    try
    {
      if (jdField_a_of_type_CooperationQzoneRDMEtraMsgCollector == null) {
        jdField_a_of_type_CooperationQzoneRDMEtraMsgCollector = new RDMEtraMsgCollector();
      }
      RDMEtraMsgCollector localRDMEtraMsgCollector = jdField_a_of_type_CooperationQzoneRDMEtraMsgCollector;
      return localRDMEtraMsgCollector;
    }
    finally {}
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activityNameQueue:\n");
    if (this.jdField_a_of_type_CooperationQzoneLoopQueue != null) {
      localStringBuilder.append(this.jdField_a_of_type_CooperationQzoneLoopQueue).append("\n");
    }
    localStringBuilder.append(" \n activityEventQueue:\n");
    if (this.b != null) {
      localStringBuilder.append(this.b);
    }
    localStringBuilder.append(" \n userActionQueue:\n");
    if (this.c != null) {
      localStringBuilder.append(this.c);
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_CooperationQzoneLoopQueue != null)
    {
      this.jdField_a_of_type_CooperationQzoneLoopQueue.a();
      this.jdField_a_of_type_CooperationQzoneLoopQueue = null;
    }
    if (this.b != null)
    {
      this.b.a();
      this.b = null;
    }
    if (this.c != null)
    {
      this.c.a();
      this.c = null;
    }
    jdField_a_of_type_CooperationQzoneRDMEtraMsgCollector = null;
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (this.jdField_a_of_type_CooperationQzoneLoopQueue != null))
    {
      if (this.jdField_a_of_type_CooperationQzoneLoopQueue.a()) {
        this.jdField_a_of_type_CooperationQzoneLoopQueue.a();
      }
      this.jdField_a_of_type_CooperationQzoneLoopQueue.a(paramString);
    }
  }
  
  public void a(String paramString, View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Actvity] ").append(paramString);
    if (paramView != null) {
      localStringBuilder.append("  click view  id:0x").append(Integer.toHexString(paramView.getId()));
    }
    c(localStringBuilder.toString());
  }
  
  public void a(String paramString, View paramView, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Actvity] ").append(paramString);
    if (paramView != null) {
      localStringBuilder.append("  actionSheet click view  id:0x").append(Integer.toHexString(paramView.getId()));
    }
    localStringBuilder.append(" which:").append(paramInt);
    a().c(localStringBuilder.toString());
  }
  
  public void a(String paramString, ViewGroup paramViewGroup, View paramView, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Actvity] ").append(paramString);
    if (paramViewGroup != null) {
      localStringBuilder.append("parent id: ").append(paramViewGroup.getId());
    }
    if (paramView != null) {
      localStringBuilder.append("view id: ").append(paramView.getId());
    }
    localStringBuilder.append(" onItemclick view  position:0x").append(Integer.toHexString(paramInt));
    localStringBuilder.append(" id").append(paramLong);
    a().c(localStringBuilder.toString());
  }
  
  public void b(String paramString)
  {
    if ((paramString != null) && (this.b != null))
    {
      if (this.b.a()) {
        this.b.a();
      }
      this.b.a(paramString);
    }
  }
  
  public void c(String paramString)
  {
    if ((paramString != null) && (this.c != null))
    {
      if (this.c.a()) {
        this.c.a();
      }
      this.c.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     cooperation.qzone.RDMEtraMsgCollector
 * JD-Core Version:    0.7.0.1
 */