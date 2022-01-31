package com.facebook.internal;

import java.util.List;

public class Utility$PermissionsPair
{
  List<String> declinedPermissions;
  List<String> grantedPermissions;
  
  public Utility$PermissionsPair(List<String> paramList1, List<String> paramList2)
  {
    this.grantedPermissions = paramList1;
    this.declinedPermissions = paramList2;
  }
  
  public List<String> getDeclinedPermissions()
  {
    return this.declinedPermissions;
  }
  
  public List<String> getGrantedPermissions()
  {
    return this.grantedPermissions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.internal.Utility.PermissionsPair
 * JD-Core Version:    0.7.0.1
 */